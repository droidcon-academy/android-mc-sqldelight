package com.droidcon.tinyinvoice.ui.customer.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.droidcon.tinyinvoice.domain.model_provider.customerList
import com.droidcon.tinyinvoice.ui.customer.CustomerListState

class CustomerListStateProvider : PreviewParameterProvider<CustomerListState> {

    override val values: Sequence<CustomerListState> =
        sequenceOf(CustomerListState(customerList = customerList))

}