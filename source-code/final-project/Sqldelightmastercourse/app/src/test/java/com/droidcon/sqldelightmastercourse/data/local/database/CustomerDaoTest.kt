package com.droidcon.sqldelightmastercourse.data.local.database

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.droidcon.db.InvoiceDatabase
import com.droidcon.sqldelightmastercourse.domain.model_provider.customerList
import com.droidcon.sqldelightmastercourse.test.SuspendSpec
import io.kotest.matchers.equals.shouldBeEqual
import kotlinx.coroutines.flow.first

class CustomerDaoTest : SuspendSpec({
    lateinit var customerDao: CustomerDao

    beforeSpec {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        InvoiceDatabase.Schema.create(driver)
        val db = InvoiceDatabase(driver)
        customerDao = CustomerDaoImpl(db)
    }

    "Empty table at db initialization" {
        val customerList = customerDao.getCustomers().first()
        customerList.size shouldBeEqual 0
    }

    "Insert customer into db" {
        val (_, name, address, phone, email) = customerList.first()
        customerDao.addUpdateCustomer(name, address, phone, email)
        val customerFromDb = customerDao.getCustomers().first()[0]
        customerFromDb.apply {
            this.name shouldBeEqual name
            this.address shouldBeEqual address
            this.phone shouldBeEqual phone
            this.email shouldBeEqual email
        }
    }

    "Delete exist customer from db" {
        val (_, name, address, phone, email) = customerList.first()
        customerDao.addUpdateCustomer(name, address, phone, email)

        val customerList = customerDao.getCustomers().first()
        customerList.size shouldBeEqual 0

        customerDao.deleteCustomer(customerId = customerList.first().id)
        val customerListAfterDeletion = customerDao.getCustomers().first()
        customerListAfterDeletion.size shouldBeEqual 0
    }

})