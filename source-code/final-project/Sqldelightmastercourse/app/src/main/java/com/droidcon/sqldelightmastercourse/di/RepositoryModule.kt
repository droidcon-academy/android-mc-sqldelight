package com.droidcon.sqldelightmastercourse.di

import com.droidcon.sqldelightmastercourse.data.repository.BusinessRepositoryImpl
import com.droidcon.sqldelightmastercourse.data.repository.CustomerRepositoryImpl
import com.droidcon.sqldelightmastercourse.data.repository.InvoiceRepositoryImpl
import com.droidcon.sqldelightmastercourse.data.repository.TaxRepositoryImpl
import com.droidcon.sqldelightmastercourse.domain.repository.BusinessRepository
import com.droidcon.sqldelightmastercourse.domain.repository.CustomerRepository
import com.droidcon.sqldelightmastercourse.domain.repository.InvoiceRepository
import com.droidcon.sqldelightmastercourse.domain.repository.TaxRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindBusinessRepository(businessRepository: BusinessRepositoryImpl): BusinessRepository

    @Binds
    fun bindCustomerRepository(customerRepository: CustomerRepositoryImpl): CustomerRepository

    @Binds
    fun bindInvoiceRepository(invoiceRepository: InvoiceRepositoryImpl): InvoiceRepository

    @Binds
    fun bindTaxRepository(taxRepository: TaxRepositoryImpl): TaxRepository

}