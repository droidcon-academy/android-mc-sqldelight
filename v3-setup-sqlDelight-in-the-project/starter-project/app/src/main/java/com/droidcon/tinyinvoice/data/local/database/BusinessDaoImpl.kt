package com.droidcon.tinyinvoice.data.local.database

import com.droidcon.tinyinvoice.domain.model.Business
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BusinessDaoImpl @Inject constructor() : BusinessDao {

    override suspend fun addUpdateBusiness(
        name: String,
        address: String,
        phone: String,
        email: String,
    ) = TODO()

    override fun getBusinesses(): Flow<List<Business>> = TODO()

    override suspend fun deleteBusiness(businessId: Long) = TODO()

    override fun lastInsertRowId(): Long = TODO()

}