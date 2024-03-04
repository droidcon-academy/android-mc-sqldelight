package com.droidcon.sqldelightmastercourse.data.repository

import com.droidcon.sqldelightmastercourse.data.local.database.BusinessDao
import com.droidcon.sqldelightmastercourse.domain.model.Business
import com.droidcon.sqldelightmastercourse.domain.repository.BusinessRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BusinessRepositoryImpl @Inject constructor(
    private val dao: BusinessDao,
) : BusinessRepository {

    override suspend fun addUpdateBusiness(
        name: String,
        address: String,
        phone: String,
        email: String
    ) = dao.addUpdateBusiness(name, address, phone, email)

    override fun getBusinesses(): Flow<List<Business>> = dao.getBusinesses()

    override suspend fun deleteMyBusiness(businessId: Long) =
        dao.deleteBusiness(businessId)
}