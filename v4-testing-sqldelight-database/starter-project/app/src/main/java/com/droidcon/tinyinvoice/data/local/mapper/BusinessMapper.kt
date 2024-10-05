package com.droidcon.tinyinvoice.data.local.mapper

import com.droidcon.db.BusinessEntity
import com.droidcon.tinyinvoice.domain.model.Business

fun BusinessEntity.toBusiness(): Business =
    Business(
        id = id,
        name = name,
        address = address,
        phone = phone,
        email = email,
    )
