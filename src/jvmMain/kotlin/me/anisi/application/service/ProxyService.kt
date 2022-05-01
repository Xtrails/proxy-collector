package me.anisi.application.service

import me.anisi.application.models.ProxyAddressDTO

interface ProxyService {
    fun saveHttpProxy(proxyAddressList: List<ProxyAddressDTO>)
    fun saveHttpsProxy(proxyAddressList: List<ProxyAddressDTO>)
    fun saveSocks4Proxy(proxyAddressList: List<ProxyAddressDTO>)
    fun saveSocks5Proxy(proxyAddressList: List<ProxyAddressDTO>)
    fun getCountAllProxy(): Map<String, Long>
}