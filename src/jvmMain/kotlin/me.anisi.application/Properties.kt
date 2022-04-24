package me.anisi.application

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

data class ProxyTypeProperties(var path: String?, var enabled: Boolean = false) {
    constructor(): this(null, false)
}

open class ProxyCollectorProperties(
    val url: String,
    val delay: Int,
    val http: ProxyTypeProperties,
    val https: ProxyTypeProperties,
    val socks4: ProxyTypeProperties,
    val socks5: ProxyTypeProperties
)

@ConstructorBinding
@ConfigurationProperties(prefix = "integration.open-proxy-space")
class OpenProxySpaceCollectorProperties(
    url: String,
    delay: Int,
    http: ProxyTypeProperties = ProxyTypeProperties(),
    https: ProxyTypeProperties = ProxyTypeProperties(),
    socks4: ProxyTypeProperties = ProxyTypeProperties(),
    socks5: ProxyTypeProperties = ProxyTypeProperties()
) : ProxyCollectorProperties(url, delay, http, https, socks4, socks5)

@ConstructorBinding
@ConfigurationProperties(prefix = "integration.proxy-scrape")
class ProxyScrapeCollectorProperties(
    url: String,
    delay: Int,
    http: ProxyTypeProperties = ProxyTypeProperties(),
    https: ProxyTypeProperties = ProxyTypeProperties(),
    socks4: ProxyTypeProperties = ProxyTypeProperties(),
    socks5: ProxyTypeProperties = ProxyTypeProperties()
) : ProxyCollectorProperties(url, delay, http, https, socks4, socks5)

@ConstructorBinding
@ConfigurationProperties(prefix = "integration.proxy-scan")
class ProxyScanCollectorProperties(
    url: String,
    delay: Int,
    http: ProxyTypeProperties = ProxyTypeProperties(),
    https: ProxyTypeProperties = ProxyTypeProperties(),
    socks4: ProxyTypeProperties = ProxyTypeProperties(),
    socks5: ProxyTypeProperties = ProxyTypeProperties()
) : ProxyCollectorProperties(url, delay, http, https, socks4, socks5)

@ConstructorBinding
@ConfigurationProperties(prefix = "integration.the-speed-x")
class TheSpeedXCollectorProperties(
    url: String,
    delay: Int,
    http: ProxyTypeProperties = ProxyTypeProperties(),
    https: ProxyTypeProperties = ProxyTypeProperties(),
    socks4: ProxyTypeProperties = ProxyTypeProperties(),
    socks5: ProxyTypeProperties = ProxyTypeProperties()
) : ProxyCollectorProperties(url, delay, http, https, socks4, socks5)