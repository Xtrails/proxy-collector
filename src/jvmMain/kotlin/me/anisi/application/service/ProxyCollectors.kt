package me.anisi.application.service

import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.HtmlPage
import me.anisi.application.*
import me.anisi.application.models.ProxyAddressDTO
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component
import java.net.URL
import java.time.LocalDateTime

@Component("openProxySpaceCollector")
@EnableConfigurationProperties(OpenProxySpaceCollectorProperties::class)
class OpenProxySpaceCollector(openProxySpaceCollectorProperties: OpenProxySpaceCollectorProperties) :
    ProxyCollector(properties = openProxySpaceCollectorProperties)

@Component("proxyScanCollector")
@EnableConfigurationProperties(ProxyScanCollectorProperties::class)
class ProxyScanCollector(proxyScanCollectorProperties: ProxyScanCollectorProperties) :
    ProxyCollector(properties = proxyScanCollectorProperties)

@Component("proxyScrapeCollector")
@EnableConfigurationProperties(ProxyScrapeCollectorProperties::class)
class ProxyScrapeCollector(proxyScrapeCollectorProperties: ProxyScrapeCollectorProperties) :
    ProxyCollector(properties = proxyScrapeCollectorProperties)

@Component("theSpeedXCollector")
@EnableConfigurationProperties(TheSpeedXCollectorProperties::class)
class TheSpeedXCollector(theSpeedXCollectorProperties: TheSpeedXCollectorProperties) :
    ProxyCollector(properties = theSpeedXCollectorProperties)


@Component("premiumProxyCollector")
@EnableConfigurationProperties(PremiumProxyCollectorProperties::class)
class PremiumProxyCollector(premiumProxyCollectorProperties: PremiumProxyCollectorProperties) :
    ProxyCollector(properties = premiumProxyCollectorProperties) {

    override fun extract(
        proxyTypeProperties: ProxyTypeProperties
    ): List<ProxyAddressDTO> {
//        val webClient = WebClient()
//        val url = URL(properties.url + proxyTypeProperties.path!!)
//        val myPage: HtmlPage = webClient.getPage(url)
//        val document: Document = Jsoup.parse(myPage.asXml())
//        val otherLinks: Elements = document.select("a[href]")
        return super.extract(proxyTypeProperties)
    }
}