package me.anisi.application

import me.anisi.application.service.ProxyCollector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CollectorsTest {

    companion object {
        private val log = LoggerFactory.getLogger(CollectorsTest::class.java)
    }

    @Autowired
    @Qualifier("theSpeedXCollector")
    lateinit var theSpeedXCollector: ProxyCollector
    @Autowired
    @Qualifier("proxyScrapeCollector")
    lateinit var proxyScrapeCollector: ProxyCollector
    @Autowired
    @Qualifier("proxyScanCollector")
    lateinit var proxyScanCollector: ProxyCollector
    @Autowired
    @Qualifier("openProxySpaceCollector")
    lateinit var openProxySpaceCollector: ProxyCollector

    @Autowired
    lateinit var theSpeedXCollectorProperties: TheSpeedXCollectorProperties
    @Autowired
    lateinit var proxyScrapeCollectorProperties: ProxyScrapeCollectorProperties
    @Autowired
    lateinit var proxyScanCollectorProperties: ProxyScanCollectorProperties
    @Autowired
    lateinit var openProxySpaceCollectorProperties: OpenProxySpaceCollectorProperties

    @Test
    fun `theSpeedXCollectorTest`() {
        assertProxyCollector(theSpeedXCollector, theSpeedXCollectorProperties)
    }

    @Test
    fun `proxyScrapeCollectorTest`() {
        assertProxyCollector(proxyScrapeCollector, proxyScrapeCollectorProperties)
    }

    @Test
    fun `proxyScanCollectorTest`() {
        assertProxyCollector(proxyScanCollector, proxyScanCollectorProperties)
    }

    @Test
    fun `openProxySpaceCollectorTest`() {
        assertProxyCollector(openProxySpaceCollector, openProxySpaceCollectorProperties)
    }

    fun assertProxyCollector(collector: ProxyCollector, properties: ProxyCollectorProperties) {
        log.info("Collector: ${collector.javaClass}")
        if (properties.http.enabled) {
            val httpList = collector.getHttpProxy(properties).second
            log.info("http proxy size:${httpList.size}")
            assertTrue { httpList.isNotEmpty() }
        }
        if (properties.https.enabled) {
            val httpsList = collector.getHttpsProxy(properties).second
            log.info("https proxy size:${httpsList.size}")
            assertTrue { httpsList.isNotEmpty() }
        }
        if (properties.socks4.enabled) {
            val socks4List = collector.getSOCKS4Proxy(properties).second
            log.info("socks4 proxy size:${socks4List.size}")
            assertTrue { socks4List.isNotEmpty() }
        }
        if (properties.socks5.enabled) {
            val socks5List = collector.getSOCKS5Proxy(properties).second
            log.info("socks5 proxy size:${socks5List.size}\n")
            assertTrue { socks5List.isNotEmpty() }
        }
    }
}