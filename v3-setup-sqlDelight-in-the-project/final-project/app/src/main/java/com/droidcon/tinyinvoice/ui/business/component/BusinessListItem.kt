package com.droidcon.tinyinvoice.ui.business.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidcon.tinyinvoice.domain.model.Business
import com.droidcon.tinyinvoice.domain.model_provider.businessList
import com.droidcon.tinyinvoice.designsystem.preview.ThemePreviews
import com.droidcon.tinyinvoice.designsystem.theme.TinyInvoiceTheme

@Composable
fun BusinessListItem(
    modifier: Modifier,
    business: Business,
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
            Text(
                text = business.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = business.completeAddress)
        }
    }
}

@ThemePreviews
@Composable
private fun BusinessListItemPrev() {
    TinyInvoiceTheme {
        BusinessListItem(
            modifier = Modifier,
            business = businessList.first(),
            onItemClick = {},
        )
    }
}