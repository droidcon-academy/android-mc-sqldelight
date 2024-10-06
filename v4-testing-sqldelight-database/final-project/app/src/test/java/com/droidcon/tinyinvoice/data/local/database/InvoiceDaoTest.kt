package com.droidcon.tinyinvoice.data.local.database

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.droidcon.db.InvoiceDatabase
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.equals.shouldBeEqual
import kotlinx.coroutines.flow.first

class InvoiceDaoTest : StringSpec({
    lateinit var invoiceDao: InvoiceDao

    beforeSpec {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        InvoiceDatabase.Schema.create(driver)
        val db = InvoiceDatabase(driver)
        invoiceDao = InvoiceDaoImpl(db)
    }

    "Empty table at db initialization" {
        val invoiceList = invoiceDao.getInvoices().first()
        invoiceList.size shouldBeEqual 0
    }

    "Insert invoice into db" {
        val businessId = -1L
        val customerId = -1L
        val taxId = -1L
        val isPaid = false
        invoiceDao.addUpdateInvoice(businessId, customerId, taxId, isPaid)

        val invoiceList = invoiceDao.getInvoices().first()
        invoiceList.size shouldBeEqual 1
    }

})