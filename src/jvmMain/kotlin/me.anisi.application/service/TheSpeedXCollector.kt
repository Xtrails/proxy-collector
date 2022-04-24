package me.anisi.application.service

import me.anisi.application.TheSpeedXCollectorProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Component

@Component("theSpeedXCollector")
@EnableConfigurationProperties(TheSpeedXCollectorProperties::class)
class TheSpeedXCollector(val properties: TheSpeedXCollectorProperties) : ProxyCollector
