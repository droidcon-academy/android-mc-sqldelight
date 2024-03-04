package com.droidcon.sqldelightmastercourse.data.local.mapper

import com.droidcon.db.BusinessEntity
import com.droidcon.sqldelightmastercourse.domain.model.Business

fun BusinessEntity.toBusiness(): Business =
    Business(
        id = id,
        name = name,
        address = address,
        phone = phone,
        email = email,
    )

fun Business.toBusinessEntity(): BusinessEntity =
    BusinessEntity(
        id = id,
        name = name,
        address = address,
        phone = phone,
        email = email,
    )
