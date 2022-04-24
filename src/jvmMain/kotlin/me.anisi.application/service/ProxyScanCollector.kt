package me.anisi.application.service

import me.anisi.application.ProxyScanCollectorProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component

@Component("proxyScanCollector")
@EnableConfigurationProperties(ProxyScanCollectorProperties::class)
class ProxyScanCollector(properties: ProxyScanCollectorProperties) : ProxyCollector