package me.anisi.application.models

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

class ProxyAddressId() : Serializable{
    constructor(host: String, port: String): this() {
        this.host = host
        this.port = port
    }
    lateinit var host: String
    lateinit var port: String
}

@Entity
@Table(name = "proxy_http")
@IdClass(ProxyAddressId::class)
open class HttpProxyAddressDAO(
    @Id
    @Column(nullable = false)
    open var  host: String,
    @Id
    @Column(nullable = false)
    open var  port: String,
    @Column(nullable = false)
    open var  source: String,
    @Column(nullable = false)
    open var  created: LocalDateTime
)

@Entity
@Table(name = "proxy_https")
@IdClass(ProxyAddressId::class)
open class HttpsProxyAddressDAO(
    @Id
    @Column(nullable = false)
    open var  host: String,
    @Id
    @Column(nullable = false)
    open var  port: String,
    @Column(nullable = false)
    open var  source: String,
    @Column(nullable = false)
    open var  created: LocalDateTime
)

@Entity
@Table(name = "proxy_socks4")
@IdClass(ProxyAddressId::class)
open class Socks4ProxyAddressDAO(
    @Id
    @Column(nullable = false)
    open var  host: String,
    @Id
    @Column(nullable = false)
    open var  port: String,
    @Column(nullable = false)
    open var  source: String,
    @Column(nullable = false)
    open var  created: LocalDateTime
)

@Entity
@Table(name = "proxy_socks5")
@IdClass(ProxyAddressId::class)
open class Socks5ProxyAddressDAO(
    @Id
    @Column(nullable = false)
    open var  host: String,
    @Id
    @Column(nullable = false)
    open var  port: String,
    @Column(nullable = false)
    open var  source: String,
    @Column(nullable = false)
    open var  created: LocalDateTime
)
