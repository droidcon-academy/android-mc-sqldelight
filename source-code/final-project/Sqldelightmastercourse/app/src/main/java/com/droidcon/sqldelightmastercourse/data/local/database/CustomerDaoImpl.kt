package com.droidcon.sqldelightmastercourse.data.local.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.droidcon.db.InvoiceDatabase
import com.droidcon.sqldelightmastercourse.data.local.mapper.toCustomer
import com.droidcon.sqldelightmastercourse.domain.model.Customer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CustomerDaoImpl @Inject constructor(
    db: InvoiceDatabase,
) : CustomerDao {

    private val queries = db.customerQueries

    override suspend fun addUpdateCustomer(
        name: String,
        address: String,
        phone: String,
        email: String
    ) = queries.addCustomer(name = name, address = address, phone = phone, email = email)

    override fun getCustomers(): Flow<List<Customer>> =
        queries.getCustomerList().asFlow().mapToList(Dispatchers.IO)
            .map { list -> list.map { it.toCustomer() } }

    override suspend fun deleteCustomer(customerId: Long) =
        queries.deleteCustomer(id = customerId)

}