package com.droidcon.sqldelightmastercourse.ui.customer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.droidcon.sqldelightmastercourse.ui.customer.component.CustomerListItem
import com.droidcon.sqldelightmastercourse.ui.invoice.preview_provider.InvoiceItemListStateProvider
import com.droidcon.sqldelightmastercourse.designsystem.component.FloatingButton
import com.droidcon.sqldelightmastercourse.designsystem.preview.ThemePreviews
import com.droidcon.sqldelightmastercourse.designsystem.theme.SqldelightMasterCourseTheme

@Composable
fun CustomerListRoute(
    viewModel: CustomerViewModel = hiltViewModel(),
    onNavigateToAddCustomerScreen: () -> Unit,
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getCustomerList()
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    CustomerListScreen(
        customerListState = state,
        onNavigateToAddCustomerScreen = onNavigateToAddCustomerScreen,
    )

}

@Composable
fun CustomerListScreen(
    customerListState: CustomerListState,
    onNavigateToAddCustomerScreen: () -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingButton(
                onClick = onNavigateToAddCustomerScreen,
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary,
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add new customer item",
                )
            }
        },
    ) { paddingValues ->

        if (customerListState.customerList.isEmpty())
            Text(
                text = "Empty!",
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(
                items = customerListState.customerList,
                key = { it.id },
            ) { customerItem ->
                CustomerListItem(
                    modifier = Modifier,
                    customer = customerItem,
                    onItemClick = {},
                )
            }
        }
    }
}

@ThemePreviews
@Composable
private fun CustomerListScreenPrev(
    @PreviewParameter(InvoiceItemListStateProvider::class)
    customerListState: CustomerListState,
) {
    SqldelightMasterCourseTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CustomerListScreen(
                customerListState = customerListState,
                onNavigateToAddCustomerScreen = {},
            )
        }
    }
}