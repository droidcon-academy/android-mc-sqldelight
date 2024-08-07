package com.droidcon.tinyinvoice.ui.invoice.addinvoice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.droidcon.tinyinvoice.designsystem.preview.ThemePreviews
import com.droidcon.tinyinvoice.designsystem.theme.TinyInvoiceTheme
import com.droidcon.tinyinvoice.ui.customer.CustomerListState
import com.droidcon.tinyinvoice.ui.customer.CustomerViewModel
import com.droidcon.tinyinvoice.ui.customer.component.CustomerListItem
import com.droidcon.tinyinvoice.ui.invoice.preview_provider.InvoiceItemListStateProvider

@Composable
fun SelectCustomerRoute(
    viewModel: CustomerViewModel = hiltViewModel(),
    onNavigateToSelectTaxScreen: (customerId: Long) -> Unit,
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getCustomerList()
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    SelectCustomerScreen(
        customerListState = state,
        onNavigateToSelectTaxScreen = onNavigateToSelectTaxScreen,
    )

}

@Composable
fun SelectCustomerScreen(
    customerListState: CustomerListState,
    onNavigateToSelectTaxScreen: (customerId: Long) -> Unit,
) {
    Column {
        Text(
            text = "Select the customer to whom you want to send the invoice ...",
            fontSize = 26.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(
                items = customerListState.customerList,
                key = { it.id },
            ) { customerItem ->
                CustomerListItem(
                    modifier = Modifier,
                    customer = customerItem,
                    onItemClick = { onNavigateToSelectTaxScreen(customerItem.id) },
                )
            }
        }

        if (customerListState.customerList.isEmpty())
            Text(
                text = "Empty!",
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
    }
}

@ThemePreviews
@Composable
private fun SelectCustomerScreenPrev(
    @PreviewParameter(InvoiceItemListStateProvider::class)
    customerListState: CustomerListState,
) {
    TinyInvoiceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SelectCustomerScreen(
                customerListState = customerListState,
                onNavigateToSelectTaxScreen = {},
            )
        }
    }
}