package me.anisi.application.service

import me.anisi.application.AddressProxyDTO
import me.anisi.application.ProxyCollectorProperties
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class OpenProxySpaceCollector: ProxyCollector {

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