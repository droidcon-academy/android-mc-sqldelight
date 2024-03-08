package com.droidcon.tinyinvoice.data.local.database

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.droidcon.db.InvoiceDatabase
import com.droidcon.tinyinvoice.domain.model_provider.taxList
import com.droidcon.tinyinvoice.test.SuspendSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.equals.shouldBeEqual
import kotlinx.coroutines.flow.first

class TaxDaoTest : SuspendSpec({
    lateinit var taxDao: TaxDao

    beforeSpec {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        InvoiceDatabase.Schema.create(driver)
        val db = InvoiceDatabase(driver)
        taxDao = TaxDaoImpl(db)
    }

    "Empty table at db initialization" {
        val taxList = taxDao.getTaxes().first()
        taxList.size shouldBeEqual 0
    }

    "Insert tax into db" {
        val (_, description, value) = taxList.first()
        taxDao.addUpdateTax(description, value)
        val taxFromDb = taxDao.getTaxes().first()[0]
        taxFromDb.apply {
            this.desc shouldBeEqual description
            this.value shouldBeEqual value
        }
    }

    "Delete exist tax from db" {
        val tax = taxList.first()
        val (_, description, value) = tax
        taxDao.addUpdateTax(description, value)
        val taxId = taxDao.lastInsertRowId()
        val newTax = tax.copy(id = taxId)

        val taxList = taxDao.getTaxes().first()
        taxList shouldContain newTax

        taxDao.deleteTax(taxId = newTax.id)
        val taxListAfterDeletion = taxDao.getTaxes().first()
        taxListAfterDeletion shouldNotContain newTax
    }

})