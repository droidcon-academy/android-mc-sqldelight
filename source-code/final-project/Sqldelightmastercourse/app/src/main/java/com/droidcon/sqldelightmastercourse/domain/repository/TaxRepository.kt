package com.droidcon.sqldelightmastercourse.domain.repository

import com.droidcon.sqldelightmastercourse.domain.model.Tax
import kotlinx.coroutines.flow.Flow

interface TaxRepository {
    suspend fun addUpdateTax(desc: String, value: Long)
    suspend fun deleteTax(taxId: Long)
    fun getTaxes(): Flow<List<Tax>>
}