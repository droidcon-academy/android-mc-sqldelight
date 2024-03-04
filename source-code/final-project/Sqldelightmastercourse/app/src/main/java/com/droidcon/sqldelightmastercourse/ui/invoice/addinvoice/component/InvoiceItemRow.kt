package com.droidcon.sqldelightmastercourse.ui.invoice.addinvoice.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.droidcon.sqldelightmastercourse.domain.model.InvoiceItem
import com.droidcon.sqldelightmastercourse.domain.model_provider.invoiceItemList
import com.droidcon.sqldelightmastercourse.designsystem.preview.ThemePreviews
import com.droidcon.sqldelightmastercourse.designsystem.theme.SqldelightMasterCourseTheme

@Composable
fun InvoiceItemRow(invoiceItem: InvoiceItem) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
        ) {
            Text(
                text = invoiceItem.desc,
                modifier = Modifier.weight(2f),
            )
            Text(
                text = invoiceItem.qty.toString(),
                modifier = Modifier.weight(1f),
            )
            Text(
                text = invoiceItem.price.toString(),
                modifier = Modifier.weight(1f),
            )
            Text(
                text = invoiceItem.amount.toString(),
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@ThemePreviews
@Composable
private fun InvoiceItemRowPrev() {
    SqldelightMasterCourseTheme {
        InvoiceItemRow(invoiceItem = invoiceItemList.first())
    }
}