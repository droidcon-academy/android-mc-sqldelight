package com.droidcon.sqldelightmastercourse.data.local.mapper

import com.droidcon.db.TaxEntity
import com.droidcon.sqldelightmastercourse.domain.model.Tax

fun TaxEntity.toTax(): Tax =
    Tax(
        id = id,
        desc = desc,
        value = value_,
    )

fun Tax.toTaxDto(): TaxEntity =
    TaxEntity(
        id = id,
        desc = desc,
        value_ = value,
    )
