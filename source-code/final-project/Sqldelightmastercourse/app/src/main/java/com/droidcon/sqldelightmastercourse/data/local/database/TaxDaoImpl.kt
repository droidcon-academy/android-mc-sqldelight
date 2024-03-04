package com.droidcon.sqldelightmastercourse.data.local.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.droidcon.db.InvoiceDatabase
import com.droidcon.sqldelightmastercourse.data.local.mapper.toTax
import com.droidcon.sqldelightmastercourse.domain.model.Tax
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaxDaoImpl @Inject constructor(
    db: InvoiceDatabase,
) : TaxDao {

    private val queries = db.taxesQueries

    override suspend fun addUpdateTax(desc: String, value: Long) =
        queries.addTax(desc = desc, value = value)

    override fun getTaxes(): Flow<List<Tax>> =
        queries.getTaxes().asFlow().mapToList(Dispatchers.IO)
            .map { list -> list.map { it.toTax() } }

    override suspend fun deleteTax(taxId: Long) = queries.deleteTax(id = taxId)

}