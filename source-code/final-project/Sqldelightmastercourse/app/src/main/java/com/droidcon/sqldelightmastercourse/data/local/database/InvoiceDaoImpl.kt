package com.droidcon.sqldelightmastercourse.data.local.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.droidcon.db.InvoiceDatabase
import com.droidcon.sqldelightmastercourse.data.local.mapper.toInvoice
import com.droidcon.sqldelightmastercourse.data.local.mapper.toInvoiceItem
import com.droidcon.sqldelightmastercourse.data.utils.orZero
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceItem
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceWithItems
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class InvoiceDaoImpl @Inject constructor(
    db: InvoiceDatabase,
) : InvoiceDao {

    private val invoiceQueries = db.invoiceQueries
    private val invoiceItemQueries = db.invoiceItemQueries

    override suspend fun addUpdateInvoice(
        businessId: Long,
        customerId: Long,
        taxId: Long,
        isPaid: Boolean
    ) = invoiceQueries.addInvoice(
        businessId = businessId,
        customerId = customerId,
        taxId = taxId,
        isPaid = if (isPaid) TRUE else FALSE,
    )

    override suspend fun addUpdateInvoiceItem(
        desc: String,
        qty: Double,
        price: Double,
        invoiceId: Long,
    ) = invoiceItemQueries.addInvoiceItem(
        desc = desc,
        qty = qty,
        price = price,
        invoiceId = invoiceId,
    )

    override fun getInvoices(): Flow<List<InvoiceWithItems>> =
        invoiceQueries.getInvoiceList().asFlow().mapToList(Dispatchers.IO)
            .map { list -> list.map { it.toInvoice() } }

    override fun getInvoiceItems(invoiceId: Long): Flow<List<InvoiceItem>> =
        invoiceItemQueries.getInvoiceItem(invoiceId = invoiceId).asFlow().mapToList(Dispatchers.IO)
            .map { list -> list.map { it.toInvoiceItem() } }

    override fun getInvoiceTotalPrice(invoiceId: Long): Double =
        invoiceItemQueries.getInvoiceTotalPrice(invoiceId = invoiceId).executeAsOne().SUM.orZero()

    override suspend fun deleteInvoice(invoiceId: Long) =
        invoiceQueries.deleteInvoice(id = invoiceId)

    override suspend fun deleteInvoiceItem(invoiceItem: InvoiceItem) =
        invoiceItemQueries.deleteInvoiceItem(id = invoiceItem.id)

    override suspend fun setPaidStatus(invoiceId: Long, status: Boolean) =
        invoiceQueries.setPaidStatus(status = if (status) TRUE else FALSE, invoiceId = invoiceId)

    override fun lastInsertRowId() =
        invoiceQueries.lastInsertRowId().executeAsOne()

}