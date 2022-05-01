package me.anisi.application.service

import me.anisi.application.ProxyCollectorProperties
import me.anisi.application.ProxyTypeProperties
import me.anisi.application.models.ProxyAddressDTO
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection
import java.time.LocalDateTime

abstract class ProxyCollector(open var properties: ProxyCollectorProperties) {
    open fun getHttpProxy(): List<ProxyAddressDTO> =
        when {
            properties.http.enabled -> extract(properties.http)
            else -> listOf()
        }

    open fun getHttpsProxy(): List<ProxyAddressDTO> =
        when {
            properties.https.enabled -> extract(properties.https)
            else -> listOf()
        }


    open fun getSOCKS4Proxy(): List<ProxyAddressDTO> =
        when {
            properties.socks4.enabled -> extract(properties.socks4)
            else -> listOf()
        }

    open fun getSOCKS5Proxy(): List<ProxyAddressDTO> =
        when {
            properties.socks5.enabled -> extract(properties.socks5)
            else -> listOf()
        }

    open fun extract(
        proxyTypeProperties: ProxyTypeProperties
    ): List<ProxyAddressDTO> {
        val url = URL(properties.url + proxyTypeProperties.path!!)
        val urlConnection: URLConnection = url.openConnection()
        urlConnection.connectTimeout = properties.connectTimeout
        urlConnection.readTimeout = properties.readTimeout
        val bufferedReader = BufferedReader(InputStreamReader(urlConnection.getInputStream()))
        val proxyAddressDTOList = mutableListOf<ProxyAddressDTO>()
        val createDateTime = LocalDateTime.now()
        val collectorName = properties.getCollectorName()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            if (line!!.isNotEmpty()) {
                val stringList = line!!.split(":")
                val host = stringList[0]
                val port = stringList[1]
                proxyAddressDTOList += ProxyAddressDTO(host, port, collectorName, createDateTime)
            }
        }
        return proxyAddressDTOList
    }
}