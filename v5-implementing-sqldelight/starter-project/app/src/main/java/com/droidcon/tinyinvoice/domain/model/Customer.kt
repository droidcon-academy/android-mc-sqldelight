package com.droidcon.tinyinvoice.domain.model

data class Customer(
    val id: Long,
    val name: String,
    val address: String,
    val phone: String,
    val email: String,
) {

    val completeAddress: String
        get() = "$address\nphone: $phone\nemail: $email"

}