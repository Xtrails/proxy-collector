package me.anisi.application.service

import me.anisi.application.AddressProxyDTO
import me.anisi.application.ProxyCollectorProperties
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection
import java.time.LocalDateTime

interface ProxyCollector {
    fun getHttpProxy(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> =
        when {
            properties.http.enabled -> extract(properties)
            else -> Pair(LocalDateTime.now(), listOf())
        }

    fun getHttpsProxy(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> =
        when {
            properties.https.enabled -> extract(properties)
            else -> Pair(LocalDateTime.now(), listOf())
        }


    fun getSOCKS4Proxy(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> =
        when {
            properties.socks4.enabled -> extract(properties)
            else -> Pair(LocalDateTime.now(), listOf())
        }

    fun getSOCKS5Proxy(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> =
        when {
            properties.socks5.enabled -> extract(properties)
            else -> Pair(LocalDateTime.now(), listOf())
        }

    fun extract(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> {
        val url = URL(properties.url + properties.http.path!!)
        val urlConnection: URLConnection = url.openConnection()
        urlConnection.connectTimeout = 3000
        urlConnection.readTimeout = 3000
        val bufferedReader = BufferedReader(InputStreamReader(urlConnection.getInputStream()))
        val addressProxyDTOList = mutableListOf<AddressProxyDTO>()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            if (line!!.isNotEmpty()) {
                val stringList = line!!.split(":")
                val host = stringList[0]
                val port = stringList[1]
                addressProxyDTOList.add(AddressProxyDTO(host, port))
            }
        }
        return Pair(LocalDateTime.now(), addressProxyDTOList)
    }
}