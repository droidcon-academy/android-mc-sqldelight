package com.droidcon.sqldelightmastercourse.data.repository

import com.droidcon.sqldelightmastercourse.data.local.database.CustomerDao
import com.droidcon.sqldelightmastercourse.domain.model.Customer
import com.droidcon.sqldelightmastercourse.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val dao: CustomerDao,
) : CustomerRepository {

    override suspend fun addUpdateCustomer(
        name: String,
        address: String,
        phone: String,
        email: String,
    ) = dao.addUpdateCustomer(name, address, phone, email)

    override fun getCustomers(): Flow<List<Customer>> {
        return dao.getCustomers()
    }

    override suspend fun deleteCustomer(customerId: Long) {
        dao.deleteCustomer(customerId = customerId)
    }
}