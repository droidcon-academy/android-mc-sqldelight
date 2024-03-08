package com.droidcon.tinyinvoice.data.local.database

import com.droidcon.tinyinvoice.domain.model.Tax
import kotlinx.coroutines.flow.Flow

interface TaxDao {
    suspend fun addUpdateTax(desc: String, value: Long)
    fun getTaxes(): Flow<List<Tax>>
    suspend fun deleteTax(taxId: Long)
    fun lastInsertRowId(): Long
}