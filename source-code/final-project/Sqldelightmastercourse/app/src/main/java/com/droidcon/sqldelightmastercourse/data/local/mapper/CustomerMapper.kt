package com.droidcon.sqldelightmastercourse.data.local.mapper

import com.droidcon.db.CustomerEntity
import com.droidcon.sqldelightmastercourse.domain.model.Customer

fun CustomerEntity.toCustomer(): Customer =
    Customer(
        id = id,
        name = name,
        address = address,
        phone = phone,
        email = email,
    )

fun Customer.toCustomerDto(): CustomerEntity =
    CustomerEntity(
        id = id,
        name = name,
        address = address,
        phone = phone,
        email = email,
    )
