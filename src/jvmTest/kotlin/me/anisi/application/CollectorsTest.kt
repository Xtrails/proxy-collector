package me.anisi.application

import me.anisi.application.service.ProxyCollector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CollectorsTest {


    companion object {
        @Autowired
        lateinit var theSpeedXCollector: ProxyCollector
        @Autowired
        lateinit var theSpeedXCollectorProperties: ProxyCollectorProperties
        @JvmStatic
        fun data() = listOf(
            Arguments.of(theSpeedXCollector, theSpeedXCollectorProperties)
        )
    }

    @ParameterizedTest(name = "collector: {0}")
    @MethodSource("data")
    fun `theSpeedXCollectorTest`(collector: ProxyCollector, properties: ProxyCollectorProperties) {
//        assertTrue { theSpeedXCollector.getHttpProxy(theSpeedXCollectorProperties).second.isNotEmpty() }
        assertTrue { collector.getHttpProxy(properties).second.isNotEmpty() }
    }
}