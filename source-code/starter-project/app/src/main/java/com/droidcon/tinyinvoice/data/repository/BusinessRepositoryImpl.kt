package com.droidcon.tinyinvoice.data.repository

import com.droidcon.tinyinvoice.data.local.database.BusinessDao
import com.droidcon.tinyinvoice.domain.model.Business
import com.droidcon.tinyinvoice.domain.repository.BusinessRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BusinessRepositoryImpl(
    private val dao: BusinessDao,
) : BusinessRepository {

    override suspend fun addUpdateBusiness(
        name: String,
        address: String,
        phone: String,
        email: String
    ) = dao.addUpdateBusiness(name, address, phone, email)

    override fun getBusinesses(): Flow<List<Business>> = dao.getBusinesses()

    override suspend fun deleteMyBusiness(businessId: Long) = dao.deleteBusiness(businessId)

    override fun lastInsertRowId(): Long = dao.lastInsertRowId()
}