package com.droidcon.sqldelightmastercourse.data.local.database

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.droidcon.db.InvoiceDatabase
import com.droidcon.sqldelightmastercourse.domain.model_provider.taxList
import com.droidcon.sqldelightmastercourse.test.SuspendSpec
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
        val (_, description, value) = taxList.first()
        taxDao.addUpdateTax(description, value)

        val taxList = taxDao.getTaxes().first()
        taxList.size shouldBeEqual 0

        taxDao.deleteTax(taxId = taxList.first().id)
        val businessListAfterDeletion = taxDao.getTaxes().first()
        businessListAfterDeletion.size shouldBeEqual 0
    }

})