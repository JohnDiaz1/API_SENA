package com.sena.apisenaspring.model

import jakarta.persistence.*

@Entity
@Table(name = "ServiceRequest")
class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val requestId: String? = null
    /*@OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "ClientId", referencedColumnName = "ClientId")
    var clientId: Client? = null */
    var clientId: String? = null
    var description: String = ""
    var requestDate: String? = ""
    var state: String? = ""

    constructor() {}

    constructor(/*clientId: Client?*/ clientId: String?, description: String, requestDate: String?, state: String?) {
        this.clientId = clientId
        this.description = description
        this.requestDate = requestDate
        this.state = state
    }

}