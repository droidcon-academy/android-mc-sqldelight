package com.droidcon.tinyinvoice.data.repository

import com.droidcon.tinyinvoice.data.local.database.CustomerDao
import com.droidcon.tinyinvoice.domain.model.Customer
import com.droidcon.tinyinvoice.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CustomerRepositoryImpl(
    private val dao: CustomerDao,
) : CustomerRepository {

    override suspend fun addUpdateCustomer(
        name: String,
        address: String,
        phone: String,
        email: String,
    ) = dao.addUpdateCustomer(name, address, phone, email)

    override fun getCustomers(): Flow<List<Customer>> = dao.getCustomers()

    override suspend fun deleteCustomer(customerId: Long) =
        dao.deleteCustomer(customerId = customerId)

    override fun lastInsertRowId(): Long = dao.lastInsertRowId()

}