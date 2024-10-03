package com.droidcon.tinyinvoice.ui.business

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
import com.droidcon.tinyinvoice.ui.business.component.BusinessListItem
import com.droidcon.tinyinvoice.ui.business.preview_provider.BusinessListStateProvider
import com.droidcon.tinyinvoice.designsystem.component.FloatingButton
import com.droidcon.tinyinvoice.designsystem.preview.ThemePreviews
import com.droidcon.tinyinvoice.designsystem.theme.TinyInvoiceTheme

@Composable
fun BusinessListRoute(
    viewModel: BusinessViewModel = hiltViewModel(),
    onNavigateToAddBusinessScreen: () -> Unit,
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getBusinessList()
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    BusinessListScreen(
        businessListState = state,
        onNavigateToAddBusinessScreen = onNavigateToAddBusinessScreen,
    )

}

@Composable
fun BusinessListScreen(
    businessListState: BusinessListState,
    onNavigateToAddBusinessScreen: () -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingButton(
                onClick = onNavigateToAddBusinessScreen,
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary,
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add new business item",
                )
            }
        },
    ) { paddingValues ->

        if (businessListState.businessList.isEmpty())
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
                items = businessListState.businessList,
                key = { it.id },
            ) { businessItem ->
                BusinessListItem(
                    modifier = Modifier,
                    business = businessItem,
                    onItemClick = {},
                )
            }
        }
    }
}

@ThemePreviews
@Composable
private fun BusinessListScreenPrev(
    @PreviewParameter(BusinessListStateProvider::class)
    businessListState: BusinessListState,
) {
    TinyInvoiceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BusinessListScreen(
                businessListState = businessListState,
                onNavigateToAddBusinessScreen = {},
            )
        }
    }
}