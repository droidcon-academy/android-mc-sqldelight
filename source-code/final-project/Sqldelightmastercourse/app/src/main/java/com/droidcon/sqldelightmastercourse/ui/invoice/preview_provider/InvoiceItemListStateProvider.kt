package com.droidcon.sqldelightmastercourse.ui.invoice.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.droidcon.sqldelightmastercourse.domain.model_provider.invoiceItemList
import com.droidcon.sqldelightmastercourse.ui.invoice.InvoiceListState

class InvoiceItemListStateProvider : PreviewParameterProvider<InvoiceListState> {

    override val values: Sequence<InvoiceListState> =
        sequenceOf(InvoiceListState(invoiceItemList = invoiceItemList))

}