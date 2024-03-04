package com.droidcon.sqldelightmastercourse.data.local.database

import com.droidcon.sqldelightmastercourse.domain.model.Business
import kotlinx.coroutines.flow.Flow

interface BusinessDao {
    suspend fun addUpdateBusiness(name: String, address: String, phone: String, email: String)
    fun getBusinesses(): Flow<List<Business>>
    suspend fun deleteBusiness(businessId: Long)
}