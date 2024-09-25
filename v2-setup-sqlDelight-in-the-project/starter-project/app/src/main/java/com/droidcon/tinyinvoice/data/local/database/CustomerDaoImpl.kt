package com.droidcon.tinyinvoice.data.local.database

import com.droidcon.tinyinvoice.domain.model.Customer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CustomerDaoImpl @Inject constructor() : CustomerDao {

    override suspend fun addUpdateCustomer(
        name: String,
        address: String,
        phone: String,
        email: String
    ) = TODO()

    override fun getCustomers(): Flow<List<Customer>> = TODO()

    override suspend fun deleteCustomer(customerId: Long) = TODO()

    override fun lastInsertRowId(): Long = TODO()

}