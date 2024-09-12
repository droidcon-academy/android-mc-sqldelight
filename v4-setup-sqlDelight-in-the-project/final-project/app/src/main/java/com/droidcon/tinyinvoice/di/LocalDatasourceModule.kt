package com.droidcon.tinyinvoice.di

import com.droidcon.tinyinvoice.data.local.database.BusinessDao
import com.droidcon.tinyinvoice.data.local.database.BusinessDaoImpl
import com.droidcon.tinyinvoice.data.local.database.CustomerDao
import com.droidcon.tinyinvoice.data.local.database.CustomerDaoImpl
import com.droidcon.tinyinvoice.data.local.database.InvoiceDao
import com.droidcon.tinyinvoice.data.local.database.InvoiceDaoImpl
import com.droidcon.tinyinvoice.data.local.database.TaxDao
import com.droidcon.tinyinvoice.data.local.database.TaxDaoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DaoModule {
    @Binds
    fun provideBusinessDao(dao: BusinessDaoImpl): BusinessDao

    @Binds
    fun provideCustomerDao(dao: CustomerDaoImpl): CustomerDao

    @Binds
    fun provideTaxDao(dao: TaxDaoImpl): TaxDao

    @Binds
    fun provideInvoiceDao(dao: InvoiceDaoImpl): InvoiceDao
}