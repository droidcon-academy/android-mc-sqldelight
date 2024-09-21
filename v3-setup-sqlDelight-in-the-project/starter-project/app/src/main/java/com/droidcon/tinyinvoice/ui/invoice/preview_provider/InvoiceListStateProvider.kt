package com.droidcon.tinyinvoice.ui.invoice.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.droidcon.tinyinvoice.domain.model_provider.invoiceList
import com.droidcon.tinyinvoice.ui.invoice.InvoiceListState

class InvoiceListStateProvider : PreviewParameterProvider<InvoiceListState> {

    override val values: Sequence<InvoiceListState> =
        sequenceOf(InvoiceListState(invoiceList = invoiceList))

}