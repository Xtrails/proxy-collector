package me.anisi.application.service

import me.anisi.application.AddressProxyDTO
import me.anisi.application.ProxyCollectorProperties
import me.anisi.application.TheSpeedXCollectorProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection
import java.time.LocalDateTime


@Component
@EnableConfigurationProperties(TheSpeedXCollectorProperties::class)
class TheSpeedXCollector(val properties: TheSpeedXCollectorProperties) : ProxyCollector {

    override fun getHttpProxy(properties: ProxyCollectorProperties): Pair<LocalDateTime, List<AddressProxyDTO>> {
        return extract(properties);
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
