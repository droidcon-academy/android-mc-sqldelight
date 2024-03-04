package com.droidcon.sqldelightmastercourse.ui.invoice.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.droidcon.sqldelightmastercourse.designsystem.preview.ThemePreviews
import com.droidcon.sqldelightmastercourse.designsystem.theme.SqldelightMasterCourseTheme
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceWithItems
import com.droidcon.sqldelightmastercourse.domain.model_provider.invoiceList

@Composable
fun InvoiceListItem(
    modifier: Modifier,
    invoice: InvoiceWithItems,
    onItemClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onItemClick() },
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "from: ${invoice.business.name}")
                Text(text = "to: ${invoice.customer.name}")
            }
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

@ThemePreviews
@Composable
private fun CustomerListItemPrev() {
    SqldelightMasterCourseTheme {
        InvoiceListItem(
            modifier = Modifier,
            invoice = invoiceList.first(),
            onItemClick = {},
        )
    }
}