package com.droidcon.sqldelightmastercourse.ui.invoice.addinvoice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.droidcon.sqldelightmastercourse.designsystem.component.FloatingButton
import com.droidcon.sqldelightmastercourse.designsystem.component.TextInput
import com.droidcon.sqldelightmastercourse.designsystem.theme.SqldelightMasterCourseTheme
import com.droidcon.sqldelightmastercourse.domain.model.Invoice
import com.droidcon.sqldelightmastercourse.ui.invoice.InvoiceListState
import com.droidcon.sqldelightmastercourse.ui.invoice.InvoiceViewModel
import com.droidcon.sqldelightmastercourse.ui.invoice.addinvoice.component.InvoiceItemRow
import com.droidcon.sqldelightmastercourse.ui.invoice.preview_provider.InvoiceItemListStateProvider

@Composable
fun AddInvoiceItemRoute(
    viewModel: InvoiceViewModel = hiltViewModel(),
    invoice: Invoice,
    onNavigateToInvoiceListScreen: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        val invoiceId = viewModel.addNewInvoice(
            businessId = invoice.businessId,
            customerId = invoice.customerId,
            taxId = invoice.taxId,
        )
        viewModel.setInvoiceId(invoiceId = invoiceId)
        viewModel.getInvoiceItemList(invoiceId = invoiceId)
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    AddInvoiceItemScreen(
        state = state,
        addNewInvoiceItem = { description, qty, price, invoiceId ->
            viewModel.addNewInvoiceItem(description, qty, price, invoiceId)
        },
        onNavigateToInvoiceListScreen = onNavigateToInvoiceListScreen,
    )

}

@Composable
fun AddInvoiceItemScreen(
    state: InvoiceListState,
    addNewInvoiceItem: (description: String, qty: Double, price: Double, invoiceId: Long) -> Unit,
    onNavigateToInvoiceListScreen: () -> Unit,
) {

    var description by rememberSaveable { mutableStateOf("") }
    var qty by rememberSaveable { mutableDoubleStateOf(1.0) }
    var price by rememberSaveable { mutableDoubleStateOf(1.0) }

    Scaffold(
        floatingActionButton = {
            FloatingButton(
                onClick = onNavigateToInvoiceListScreen,
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary,
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Add new customer item",
                )
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Text(
                text = "Add invoice items",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                TextInput(
                    label = "description",
                    value = description,
                    modifier = Modifier.weight(2f),
                    onValueChange = { description = it },
                )
                Spacer(modifier = Modifier.width(4.dp))
                TextInput(
                    label = "qty",
                    value = qty.toString(),
                    modifier = Modifier.weight(1f),
                    onValueChange = { qty = it.toDouble() },
                )
                Spacer(modifier = Modifier.width(4.dp))

                TextInput(
                    label = "price",
                    value = price.toString(),
                    modifier = Modifier.weight(1f),
                    onValueChange = { price = it.toDouble() },
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Button(onClick = {
                    addNewInvoiceItem(description, qty, price, state.newInvoiceId)
                    description = ""
                    qty = 1.0
                    price = 1.0
                }) {
                    Text(text = "Add")
                }
            }
            HorizontalDivider()
            Text(
                text = "Invoice",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(
                    items = state.invoiceItemList,
                ) { item ->
                    InvoiceItemRow(invoiceItem = item)
                }
            }
        }
    }
}

@Preview
@Composable
private fun AddInvoiceItemScreenPrev(
    @PreviewParameter(InvoiceItemListStateProvider::class)
    state: InvoiceListState,
) {
    SqldelightMasterCourseTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AddInvoiceItemScreen(
                state = state,
                addNewInvoiceItem = { _, _, _, _ -> },
                onNavigateToInvoiceListScreen = {},
            )
        }
    }
}