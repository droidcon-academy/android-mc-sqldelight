package com.droidcon.tinyinvoice.data.local.mapper

import com.droidcon.db.TaxEntity
import com.droidcon.tinyinvoice.domain.model.Tax

fun TaxEntity.toTax(): Tax =
    Tax(
        id = id,
        desc = desc,
        value = value_,
    )
