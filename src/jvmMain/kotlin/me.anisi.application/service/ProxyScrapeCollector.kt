package me.anisi.application.service

import me.anisi.application.ProxyScrapeCollectorProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component

@Component("proxyScrapeCollector")
@EnableConfigurationProperties(ProxyScrapeCollectorProperties::class)
class ProxyScrapeCollector(val properties: ProxyScrapeCollectorProperties) : ProxyCollector