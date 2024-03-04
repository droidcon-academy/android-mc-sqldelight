package com.droidcon.sqldelightmastercourse.ui.invoice.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.droidcon.sqldelightmastercourse.domain.model_provider.invoiceList
import com.droidcon.sqldelightmastercourse.ui.invoice.InvoiceListState

class InvoiceListStateProvider : PreviewParameterProvider<InvoiceListState> {

    override val values: Sequence<InvoiceListState> =
        sequenceOf(InvoiceListState(invoiceList = invoiceList))

}