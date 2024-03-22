package com.droidcon.tinyinvoice.data.local.database

import com.droidcon.tinyinvoice.domain.model.Tax
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaxDaoImpl @Inject constructor() : TaxDao {

    override suspend fun addUpdateTax(desc: String, value: Long) = TODO()

    override fun getTaxes(): Flow<List<Tax>> = TODO()

    override suspend fun deleteTax(taxId: Long) = TODO()

    override fun lastInsertRowId(): Long = TODO()

}