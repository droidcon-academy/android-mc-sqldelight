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
import com.droidcon.tinyinvoice.ui.tax.TaxListState
import com.droidcon.tinyinvoice.ui.tax.TaxViewModel
import com.droidcon.tinyinvoice.ui.tax.component.TaxListItem
import com.droidcon.tinyinvoice.ui.tax.preview_provider.TaxListStateProvider

@Composable
fun SelectTaxRoute(
    viewModel: TaxViewModel = hiltViewModel(),
    onNavigateToAddInvoiceItemScreen: (taxId: Long) -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getTaxList()
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    SelectTaxScreen(
        taxListState = state,
        onNavigateToAddInvoiceItemScreen = onNavigateToAddInvoiceItemScreen,
    )
}

@Composable
fun SelectTaxScreen(
    taxListState: TaxListState,
    onNavigateToAddInvoiceItemScreen: (taxId: Long) -> Unit,
) {
    Column {
        Text(
            text = "Select the Tax to whom you want to send the invoice ...",
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
                items = taxListState.taxList,
                key = { it.id },
            ) { taxItem ->
                TaxListItem(
                    modifier = Modifier,
                    tax = taxItem,
                    onItemClick = { onNavigateToAddInvoiceItemScreen(taxItem.id) },
                )
            }
        }

        if (taxListState.taxList.isEmpty())
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
private fun SelectTaxScreenPrev(
    @PreviewParameter(TaxListStateProvider::class)
    taxListState: TaxListState,
) {
    TinyInvoiceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SelectTaxScreen(
                taxListState = taxListState,
                onNavigateToAddInvoiceItemScreen = {},
            )
        }
    }
}