package com.droidcon.tinyinvoice.data.local.mapper

import com.droidcon.db.CustomerEntity
import com.droidcon.tinyinvoice.domain.model.Customer

fun CustomerEntity.toCustomer(): Customer =
    Customer(
        id = id,
        name = name,
        address = address,
        phone = phone,
        email = email,
    )
