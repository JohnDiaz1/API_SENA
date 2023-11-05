package com.sena.apisenaspring.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val employeeId: String? = null
    var name: String = ""
    var phone: String = ""
    var position: String = ""
    var state: String = ""

    constructor() {}

    constructor(name: String, phone: String, position: String, state: String) {
        this.name = name
        this.phone = phone
        this.position = position
        this.state = state
    }

}