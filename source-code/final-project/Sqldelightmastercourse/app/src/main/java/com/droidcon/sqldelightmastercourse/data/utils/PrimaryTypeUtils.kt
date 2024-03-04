package com.droidcon.sqldelightmastercourse.data.utils

fun Long?.orZero(): Long = this ?: 0L
fun Double?.orZero(): Double = this ?: 0.0