package com.droidcon.sqldelightmastercourse.data.local.database

import com.droidcon.sqldelightmastercourse.domain.model.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerDao {
    suspend fun addUpdateCustomer(name: String, address: String, phone: String, email: String)
    fun getCustomers(): Flow<List<Customer>>
    suspend fun deleteCustomer(customerId: Long)
}