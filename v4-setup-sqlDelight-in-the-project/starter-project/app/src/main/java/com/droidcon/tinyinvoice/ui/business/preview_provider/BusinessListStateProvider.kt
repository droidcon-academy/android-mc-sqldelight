package com.droidcon.tinyinvoice.ui.business.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.droidcon.tinyinvoice.domain.model_provider.businessList
import com.droidcon.tinyinvoice.ui.business.BusinessListState

class BusinessListStateProvider : PreviewParameterProvider<BusinessListState> {

    override val values: Sequence<BusinessListState> =
        sequenceOf(BusinessListState(businessList = businessList))

}