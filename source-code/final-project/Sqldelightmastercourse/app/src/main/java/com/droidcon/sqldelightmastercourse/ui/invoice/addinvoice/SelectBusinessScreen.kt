package com.droidcon.sqldelightmastercourse.ui.invoice.addinvoice

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
import com.droidcon.sqldelightmastercourse.designsystem.preview.ThemePreviews
import com.droidcon.sqldelightmastercourse.designsystem.theme.SqldelightMasterCourseTheme
import com.droidcon.sqldelightmastercourse.ui.business.BusinessListState
import com.droidcon.sqldelightmastercourse.ui.business.BusinessViewModel
import com.droidcon.sqldelightmastercourse.ui.business.component.BusinessListItem
import com.droidcon.sqldelightmastercourse.ui.business.preview_provider.BusinessListStateProvider

@Composable
fun SelectBusinessRoute(
    viewModel: BusinessViewModel = hiltViewModel(),
    onNavigateToSelectCustomerScreen: (businessId: Long) -> Unit,
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getBusinessList()
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    SelectBusinessScreen(
        businessListState = state,
        onNavigateToSelectCustomerScreen = onNavigateToSelectCustomerScreen,
    )

}

@Composable
fun SelectBusinessScreen(
    businessListState: BusinessListState,
    onNavigateToSelectCustomerScreen: (businessId: Long) -> Unit,
) {
    Column {
        Text(
            text = "Select a business from where you want to create an invoice ...",
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
                items = businessListState.businessList,
                key = { it.id },
            ) { businessItem ->
                BusinessListItem(
                    modifier = Modifier,
                    business = businessItem,
                    onItemClick = { onNavigateToSelectCustomerScreen(businessItem.id) },
                )
            }
        }

        if (businessListState.businessList.isEmpty())
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
private fun SelectBusinessScreenPrev(
    @PreviewParameter(BusinessListStateProvider::class)
    businessListState: BusinessListState,
) {
    SqldelightMasterCourseTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SelectBusinessScreen(
                businessListState = businessListState,
                onNavigateToSelectCustomerScreen = {},
            )
        }
    }
}