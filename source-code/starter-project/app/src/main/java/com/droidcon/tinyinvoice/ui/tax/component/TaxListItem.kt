package com.droidcon.tinyinvoice.ui.tax.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.sp
import com.droidcon.tinyinvoice.domain.model.Tax
import com.droidcon.tinyinvoice.domain.model_provider.taxList
import com.droidcon.tinyinvoice.designsystem.preview.ThemePreviews
import com.droidcon.tinyinvoice.designsystem.theme.TinyInvoiceTheme

@Composable
fun TaxListItem(
    modifier: Modifier,
    tax: Tax,
    onItemClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onItemClick() }
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = tax.taxLabel,
                fontSize = 18.sp
            )
        }
    }
}

@ThemePreviews
@Composable
private fun TaxListItemPrev() {
    TinyInvoiceTheme {
        TaxListItem(
            modifier = Modifier,
            tax = taxList.first(),
            onItemClick = {},
        )
    }
}