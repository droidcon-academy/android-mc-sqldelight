package com.droidcon.sqldelightmastercourse.domain.repository

import com.droidcon.sqldelightmastercourse.domain.model.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {
    suspend fun addUpdateCustomer(name: String, address: String, phone: String, email: String)
    fun getCustomers(): Flow<List<Customer>>
    suspend fun deleteCustomer(customerId: Long)
}