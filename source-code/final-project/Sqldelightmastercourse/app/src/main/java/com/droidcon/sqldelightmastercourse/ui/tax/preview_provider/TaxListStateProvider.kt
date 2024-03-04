package com.droidcon.sqldelightmastercourse.ui.tax.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.droidcon.sqldelightmastercourse.domain.model_provider.taxList
import com.droidcon.sqldelightmastercourse.ui.tax.TaxListState

class TaxListStateProvider : PreviewParameterProvider<TaxListState> {
    override val values: Sequence<TaxListState> =
        sequenceOf(TaxListState(taxList = taxList))
}