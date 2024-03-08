package com.droidcon.tinyinvoice.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Invoice(
    val id: Long,
    val businessId: Long,
    val customerId: Long,
    val taxId: Long,
    var isPaid: Boolean = false,
) : Parcelable