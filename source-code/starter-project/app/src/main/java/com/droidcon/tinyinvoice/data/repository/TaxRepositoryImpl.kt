package com.droidcon.tinyinvoice.data.repository

import com.droidcon.tinyinvoice.data.local.database.TaxDao
import com.droidcon.tinyinvoice.domain.model.Tax
import com.droidcon.tinyinvoice.domain.repository.TaxRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaxRepositoryImpl(
    private val dao: TaxDao,
) : TaxRepository {
    override suspend fun addUpdateTax(desc: String, value: Long) =
        dao.addUpdateTax(desc = desc, value = value)

    override fun getTaxes(): Flow<List<Tax>> = dao.getTaxes()

    override suspend fun deleteTax(taxId: Long) = dao.deleteTax(taxId)

    override fun lastInsertRowId(): Long = dao.lastInsertRowId()

}