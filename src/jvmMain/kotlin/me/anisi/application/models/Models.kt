package me.anisi.application.models

import java.time.LocalDateTime

data class ProxyAddressDTO(
    val host: String,
    val port: String,
    val source: String,
    val created: LocalDateTime
)