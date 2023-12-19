package com.sena.apisenaspring.model

import jakarta.persistence.*

@Entity
 class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var clientId: String? = ""
    var cedula: String = ""
    var name: String = ""
    var address: String = ""
    var phone: String = ""
    var email: String = ""

    constructor() {}

    constructor(clientId: String?, cedula: String, name: String, address: String, phone: String, email: String) {
        this.clientId = clientId
        this.cedula = cedula
        this.name = name
        this.address = address
        this.phone = phone
        this.email = email
    }

    constructor(cedula: String, name: String, address: String, phone: String, email: String) {
        this.cedula = cedula
        this.name = name
        this.address = address
        this.phone = phone
        this.email = email
    }

}