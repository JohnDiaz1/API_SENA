package com.sena.apisenaspring.model

import jakarta.persistence.*

@Entity
 class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val clientId: String? = null
    var cedula: String = ""
    var name: String = ""
    var address: String = ""
    var phone: String = ""
    var email: String = ""

    constructor() {}

    constructor(cedula: String, name: String, address: String, phone: String, email: String) {
        this.cedula = cedula
        this.name = name
        this.address = address
        this.phone = phone
        this.email = email
    }

}