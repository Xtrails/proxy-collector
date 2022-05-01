package me.anisi.application

import me.anisi.application.models.*
import org.springframework.data.repository.CrudRepository

interface HttpAddressRepository : CrudRepository<HttpProxyAddressDAO, ProxyAddressId>
interface HttpsAddressRepository : CrudRepository<HttpsProxyAddressDAO, ProxyAddressId>
interface Socks4AddressRepository : CrudRepository<Socks4ProxyAddressDAO, ProxyAddressId>
interface Socks5AddressRepository : CrudRepository<Socks5ProxyAddressDAO, ProxyAddressId>