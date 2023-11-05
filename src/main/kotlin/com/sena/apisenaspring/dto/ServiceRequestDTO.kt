package com.sena.apisenaspring.dto

import com.sena.apisenaspring.model.Client

data class ServiceRequestDTO (
    val requestId: String?,
    var clientId: String?,
    //var clientId: Client?,
    var description: String,
    var requestDate: String?,
    var state: String
)