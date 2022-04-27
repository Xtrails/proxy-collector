package me.anisi.application.service

import me.anisi.application.HttpAddressRepository
import me.anisi.application.HttpsAddressRepository
import me.anisi.application.Socks4AddressRepository
import me.anisi.application.Socks5AddressRepository
import me.anisi.application.mapper.ProxyMapper
import me.anisi.application.models.ProxyAddressDTO
import org.springframework.stereotype.Service

@Service
class ProxyServiceImpl(
    var httpAddressRepository: HttpAddressRepository,
    var httpsAddressRepository: HttpsAddressRepository,
    var socks4AddressRepository: Socks4AddressRepository,
    var socks5AddressRepository: Socks5AddressRepository,
    var proxyMapper: ProxyMapper
) : ProxyService {
    override fun saveHttpProxy(proxyAddressList: List<ProxyAddressDTO>) {
        httpAddressRepository.saveAll(proxyMapper.mapHttp(proxyAddressList))
    }

    override fun saveHttpsProxy(proxyAddressList: List<ProxyAddressDTO>) {
        httpsAddressRepository.saveAll(proxyMapper.mapHttps(proxyAddressList))
    }

    override fun saveSocks4Proxy(proxyAddressList: List<ProxyAddressDTO>) {
        socks4AddressRepository.saveAll(proxyMapper.mapSocks4(proxyAddressList))
    }

    override fun saveSocks5Proxy(proxyAddressList: List<ProxyAddressDTO>) {
        socks5AddressRepository.saveAll(proxyMapper.mapSocks5(proxyAddressList))
    }

    override fun getCountAllProxy(): Map<String, Long> =
        hashMapOf(
            Pair("HTTP", httpAddressRepository.count()),
            Pair("HTTPS", httpsAddressRepository.count()),
            Pair("SOCKS4", socks4AddressRepository.count()),
            Pair("SOCKS5", socks5AddressRepository.count())
        )
}