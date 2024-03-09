package com.droidcon.tinyinvoice.data.local.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.droidcon.db.InvoiceDatabase
import com.droidcon.tinyinvoice.data.local.mapper.toBusiness
import com.droidcon.tinyinvoice.domain.model.Business
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BusinessDaoImpl @Inject constructor(
    db: InvoiceDatabase,
) : BusinessDao {

    private val queries = db.businessQueries

    override suspend fun addUpdateBusiness(
        name: String,
        address: String,
        phone: String,
        email: String,
    ) = queries.addBusiness(name = name, address = address, phone = phone, email = email)

    override fun getBusinesses(): Flow<List<Business>> =
        queries.getBusinessList().asFlow().mapToList(Dispatchers.IO)
            .map { list -> list.map { it.toBusiness() } }

    override suspend fun deleteBusiness(businessId: Long) = queries.deleteBusiness(id = businessId)

    override fun lastInsertRowId(): Long = queries.lastInsertRowId().executeAsOne()

}