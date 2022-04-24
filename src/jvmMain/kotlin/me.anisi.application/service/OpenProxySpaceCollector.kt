package me.anisi.application.service

import me.anisi.application.OpenProxySpaceCollectorProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component

@Component("openProxySpaceCollector")
@EnableConfigurationProperties(OpenProxySpaceCollectorProperties::class)
class OpenProxySpaceCollector(properties: OpenProxySpaceCollectorProperties) : ProxyCollector