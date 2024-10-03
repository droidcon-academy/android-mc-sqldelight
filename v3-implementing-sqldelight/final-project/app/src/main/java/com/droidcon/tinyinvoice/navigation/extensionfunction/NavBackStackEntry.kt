package com.droidcon.tinyinvoice.navigation.extensionfunction

import androidx.navigation.NavBackStackEntry

inline fun <T> NavBackStackEntry.parcelableData(key: String): T? {
    return arguments?.parcelable(key) as? T
}
