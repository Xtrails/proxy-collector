package me.anisi.application

import me.anisi.application.service.ProxyCollector
import me.anisi.application.service.ProxyScrapeCollector
import me.anisi.application.service.ProxyService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@EnableScheduling
class Schedulers(
    var proxyService: ProxyService,
    var theSpeedXCollector: ProxyCollector,
    var proxyScrapeCollector: ProxyCollector
) {

    companion object {
        private val log = LoggerFactory.getLogger(Schedulers::class.java)
    }

    @Scheduled(fixedDelayString = "\${integration.the-speed-x.delay}")
    fun theSpeedXCollectorScheduler() {
        log.info("Запускаем коллектор: theSpeedXCollector")
        updateAllProxy(theSpeedXCollector)
    }

    @Scheduled(fixedDelayString = "\${integration.proxy-scrape.delay}")
    fun proxyScrapeCollectorScheduler() {
        log.info("Запускаем коллектор: proxyScrapeCollector")
        updateAllProxy(proxyScrapeCollector)
    }

    @Scheduled(initialDelay = 15000, fixedDelay = 600000)
    fun infoScheduler() {
        val proxyInfo = proxyService.getCountAllProxy()
        log.info("Всего прокси: $proxyInfo\n")
    }

    private fun updateAllProxy(proxyCollector: ProxyCollector){
        val httpProxy = proxyCollector.getHttpProxy()
        proxyService.saveHttpProxy(httpProxy)
        log.info("Получено и обновлено HTTP прокси: ${httpProxy.size}")

        val httpsProxy = proxyCollector.getHttpsProxy()
        proxyService.saveHttpsProxy(httpsProxy)
        log.info("Получено и обновлено HTTPS прокси: ${httpsProxy.size}")

        val socks4Proxy = proxyCollector.getSOCKS4Proxy()
        proxyService.saveSocks4Proxy(socks4Proxy)
        log.info("Получено и обновлено SOCKS4 прокси: ${socks4Proxy.size}")

        val socks5Proxy = proxyCollector.getSOCKS5Proxy()
        proxyService.saveSocks5Proxy(socks5Proxy)
        log.info("Получено и обновлено SOCKS5 прокси: ${socks5Proxy.size}\n")
    }
}