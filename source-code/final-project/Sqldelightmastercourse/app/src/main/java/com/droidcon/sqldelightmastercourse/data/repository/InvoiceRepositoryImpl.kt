package com.droidcon.sqldelightmastercourse.data.repository

import com.droidcon.sqldelightmastercourse.data.local.database.InvoiceDao
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceItem
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceWithItems
import com.droidcon.sqldelightmastercourse.domain.repository.InvoiceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InvoiceRepositoryImpl @Inject constructor(
    private val dao: InvoiceDao,
) : InvoiceRepository {

    override suspend fun addInvoice(
        businessId: Long,
        customerId: Long,
        taxId: Long,
        isPaid: Boolean
    ) =
        dao.addUpdateInvoice(businessId, customerId, taxId, isPaid)

    override suspend fun addInvoiceItem(desc: String, qty: Double, price: Double, invoiceId: Long) =
        dao.addUpdateInvoiceItem(desc, qty, price, invoiceId)

    override suspend fun updateInvoice(
        businessId: Long,
        customerId: Long,
        taxId: Long,
        isPaid: Boolean
    ) = dao.addUpdateInvoice(businessId, customerId, taxId, isPaid)

    override suspend fun updateInvoiceItem(
        desc: String,
        qty: Double,
        price: Double,
        invoiceId: Long,
    ) = dao.addUpdateInvoiceItem(desc, qty, price, invoiceId)

    override suspend fun deleteInvoiceItem(id: Long) {
        val item = InvoiceItem(id, "", 0.0, 0.0, -1)
        dao.deleteInvoiceItem(item)
    }

    override fun getInvoices(): Flow<List<InvoiceWithItems>> =
        dao.getInvoices()

    override fun getInvoiceItems(invoiceId: Long): Flow<List<InvoiceItem>> =
        dao.getInvoiceItems(invoiceId)

    override fun getInvoiceTotalPrice(invoiceId: Long): Double =
        dao.getInvoiceTotalPrice(invoiceId = invoiceId)

    override suspend fun setPaidStatus(invoiceId: Long, status: Boolean) =
        dao.setPaidStatus(invoiceId, status)

    override suspend fun deleteInvoice(id: Long) =
        dao.deleteInvoice(invoiceId = id)

    override fun lastInsertRowId(): Long = dao.lastInsertRowId()

}