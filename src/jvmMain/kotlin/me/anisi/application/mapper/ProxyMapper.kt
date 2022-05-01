package me.anisi.application.mapper

import me.anisi.application.models.*
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component
class ProxyMapper {
    fun mapHttp(source: ProxyAddressDTO): HttpProxyAddressDAO =
        HttpProxyAddressDAO(source.host, source.port, source.source, source.created)

    fun mapHttps(source: ProxyAddressDTO): HttpsProxyAddressDAO =
        HttpsProxyAddressDAO(source.host, source.port, source.source, source.created)

    fun mapSocks4(source: ProxyAddressDTO): Socks4ProxyAddressDAO =
        Socks4ProxyAddressDAO(source.host, source.port, source.source, source.created)

    fun mapSocks5(source: ProxyAddressDTO): Socks5ProxyAddressDAO =
        Socks5ProxyAddressDAO(source.host, source.port, source.source, source.created)

    fun mapHttp(source: List<ProxyAddressDTO>): List<HttpProxyAddressDAO> =
        source.stream().map { mapHttp(it) }.toList()

    fun mapHttps(source: List<ProxyAddressDTO>): List<HttpsProxyAddressDAO> =
        source.stream().map { mapHttps(it) }.toList()

    fun mapSocks4(source: List<ProxyAddressDTO>): List<Socks4ProxyAddressDAO> =
        source.stream().map { mapSocks4(it) }.toList()

    fun mapSocks5(source: List<ProxyAddressDTO>): List<Socks5ProxyAddressDAO> =
        source.stream().map { mapSocks5(it) }.toList()
}