package com.droidcon.sqldelightmastercourse.domain.model

data class Tax(
    val id: Long,
    val desc: String,
    val value: Long,
) {
    val taxLabel
        get() = "$desc ($value%)"
}