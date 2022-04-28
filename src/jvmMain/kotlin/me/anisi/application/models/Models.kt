package me.anisi.application.models

import java.time.LocalDateTime

/**
 * DTO адреса прокси
 */
data class ProxyAddressDTO(
    /**
     * Хост
     */
    val host: String,
    /**
     * Порт
     */
    val port: String,
    /**
     * Источник
     */
    val source: String,
    /**
     * Дата создания
     */
    val created: LocalDateTime
)