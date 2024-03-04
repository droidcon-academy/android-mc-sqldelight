package com.droidcon.sqldelightmastercourse.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.droidcon.db.InvoiceDatabase
import com.droidcon.sqldelightmastercourse.data.local.database.BusinessDao
import com.droidcon.sqldelightmastercourse.data.local.database.BusinessDaoImpl
import com.droidcon.sqldelightmastercourse.data.local.database.CustomerDao
import com.droidcon.sqldelightmastercourse.data.local.database.CustomerDaoImpl
import com.droidcon.sqldelightmastercourse.data.local.database.InvoiceDao
import com.droidcon.sqldelightmastercourse.data.local.database.InvoiceDaoImpl
import com.droidcon.sqldelightmastercourse.data.local.database.TaxDao
import com.droidcon.sqldelightmastercourse.data.local.database.TaxDaoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDatasourceModule {

    @Singleton
    @Provides
    fun provideInvoiceDatabase(app: Application): InvoiceDatabase {
        val driver: SqlDriver = AndroidSqliteDriver(InvoiceDatabase.Schema, app, "InvoiceDatabase")
        return InvoiceDatabase(driver)
    }

    // TODO: make it @Bind?
    @Provides
    fun provideBusinessDao(dao: BusinessDaoImpl): BusinessDao = dao

    // TODO: make it @Bind?
    @Provides
    fun provideCustomerDao(dao: CustomerDaoImpl): CustomerDao = dao

    // TODO: make it @Bind?
    @Provides
    fun provideTaxDao(dao: TaxDaoImpl): TaxDao = dao

    // TODO: make it @Bind?
    @Provides
    fun provideInvoiceDao(dao: InvoiceDaoImpl): InvoiceDao = dao

}