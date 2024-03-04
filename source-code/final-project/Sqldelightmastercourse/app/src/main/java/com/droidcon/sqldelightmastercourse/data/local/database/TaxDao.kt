package com.droidcon.sqldelightmastercourse.data.local.database

import com.droidcon.sqldelightmastercourse.domain.model.Tax
import kotlinx.coroutines.flow.Flow

interface TaxDao {
    suspend fun addUpdateTax(desc: String, value: Long)
    fun getTaxes(): Flow<List<Tax>>
    suspend fun deleteTax(taxId: Long)
}