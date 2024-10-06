package com.droidcon.tinyinvoice.data.local.database

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.droidcon.db.InvoiceDatabase
import com.droidcon.tinyinvoice.domain.model_provider.customerList
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.equals.shouldBeEqual
import kotlinx.coroutines.flow.first

class CustomerDaoTest : StringSpec({
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
        val customer = customerList.first()
        val (_, name, address, phone, email) = customer
        customerDao.addUpdateCustomer(name, address, phone, email)
        val customerId = customerDao.lastInsertRowId()
        val newCustomer = customer.copy(id = customerId)

        val customerList = customerDao.getCustomers().first()
        customerList shouldContain newCustomer

        customerDao.deleteCustomer(customerId = newCustomer.id)
        val customerListAfterDeletion = customerDao.getCustomers().first()
        customerListAfterDeletion shouldNotContain newCustomer
    }

})