package com.droidcon.sqldelightmastercourse.ui.customer.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.droidcon.sqldelightmastercourse.domain.model_provider.customerList
import com.droidcon.sqldelightmastercourse.ui.customer.CustomerListState

class CustomerListStateProvider : PreviewParameterProvider<CustomerListState> {

    override val values: Sequence<CustomerListState> =
        sequenceOf(CustomerListState(customerList = customerList))

}