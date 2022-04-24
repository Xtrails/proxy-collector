package me.anisi.application.service

import me.anisi.application.AddressProxyDTO
import me.anisi.application.ProxyCollectorProperties
import java.time.LocalDateTime

class ProxyScanCollector : ProxyCollector {
    override fun getHttpProxy(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> {
        TODO("Not yet implemented")
    }

    override fun getHttpsProxy(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> {
        TODO("Not yet implemented")
    }

    override fun getSOCKS4Proxy(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> {
        TODO("Not yet implemented")
    }

    override fun getSOCKS5Proxy(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> {
        TODO("Not yet implemented")
    }
}