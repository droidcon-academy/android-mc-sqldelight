package com.droidcon.sqldelightmastercourse.ui.business.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.droidcon.sqldelightmastercourse.domain.model_provider.businessList
import com.droidcon.sqldelightmastercourse.ui.business.BusinessListState

class BusinessListStateProvider : PreviewParameterProvider<BusinessListState> {

    override val values: Sequence<BusinessListState> =
        sequenceOf(BusinessListState(businessList = businessList))

}