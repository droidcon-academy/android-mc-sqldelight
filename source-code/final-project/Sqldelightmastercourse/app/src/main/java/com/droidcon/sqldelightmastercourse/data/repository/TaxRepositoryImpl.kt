package com.droidcon.sqldelightmastercourse.data.repository

import com.droidcon.sqldelightmastercourse.data.local.database.TaxDao
import com.droidcon.sqldelightmastercourse.domain.model.Tax
import com.droidcon.sqldelightmastercourse.domain.repository.TaxRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaxRepositoryImpl @Inject constructor(
    private val dao: TaxDao,
) : TaxRepository {
    override suspend fun addUpdateTax(desc: String, value: Long) =
        dao.addUpdateTax(desc = desc, value = value)

    override fun getTaxes(): Flow<List<Tax>> {
        return dao.getTaxes()
    }

    override suspend fun deleteTax(taxId: Long) {
        dao.deleteTax(taxId)
    }
}