package com.droidcon.tinyinvoice.data.local.database

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.droidcon.db.InvoiceDatabase
import com.droidcon.tinyinvoice.domain.model_provider.businessList
import com.droidcon.tinyinvoice.test.SuspendSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.equals.shouldBeEqual
import kotlinx.coroutines.flow.first

class BusinessDaoTest : SuspendSpec({
    lateinit var businessDao: BusinessDao

    beforeSpec {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        InvoiceDatabase.Schema.create(driver)
        val db = InvoiceDatabase(driver)
        businessDao = BusinessDaoImpl(db)
    }

    "Empty table at db initialization" {
        val businessList = businessDao.getBusinesses().first()
        businessList.size shouldBeEqual 0
    }

    "Insert business into db" {
        val (_, name, address, phone, email) = businessList.first()
        businessDao.addUpdateBusiness(name, address, phone, email)
        val businessFromDb = businessDao.getBusinesses().first()[0]
        businessFromDb.apply {
            this.name shouldBeEqual name
            this.address shouldBeEqual address
            this.phone shouldBeEqual phone
            this.email shouldBeEqual email
        }
    }

    "Delete exist business from db" {
        val business = businessList.first()
        val (_, name, address, phone, email) = business
        businessDao.addUpdateBusiness(name, address, phone, email)
        val businessId = businessDao.lastInsertRowId()
        val newBusiness = business.copy(id = businessId)

        val businessList = businessDao.getBusinesses().first()
        businessList shouldContain newBusiness

        businessDao.deleteBusiness(businessId = newBusiness.id)
        val businessListAfterDeletion = businessDao.getBusinesses().first()
        businessListAfterDeletion shouldNotContain newBusiness
    }

})