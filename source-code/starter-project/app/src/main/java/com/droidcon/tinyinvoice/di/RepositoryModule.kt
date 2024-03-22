package com.droidcon.tinyinvoice.di

import com.droidcon.tinyinvoice.data.repository.BusinessRepositoryImpl
import com.droidcon.tinyinvoice.data.repository.CustomerRepositoryImpl
import com.droidcon.tinyinvoice.data.repository.InvoiceRepositoryImpl
import com.droidcon.tinyinvoice.data.repository.TaxRepositoryImpl
import com.droidcon.tinyinvoice.domain.repository.BusinessRepository
import com.droidcon.tinyinvoice.domain.repository.CustomerRepository
import com.droidcon.tinyinvoice.domain.repository.InvoiceRepository
import com.droidcon.tinyinvoice.domain.repository.TaxRepository
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