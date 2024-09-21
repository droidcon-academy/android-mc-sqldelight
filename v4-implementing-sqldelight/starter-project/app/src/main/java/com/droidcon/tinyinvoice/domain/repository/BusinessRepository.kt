package com.droidcon.tinyinvoice.domain.repository

import com.droidcon.tinyinvoice.domain.model.Business
import kotlinx.coroutines.flow.Flow

interface BusinessRepository {
    suspend fun addUpdateBusiness(name: String, address: String, phone: String, email: String)
    fun getBusinesses(): Flow<List<Business>>
    suspend fun deleteMyBusiness(businessId: Long)
    fun lastInsertRowId(): Long
}