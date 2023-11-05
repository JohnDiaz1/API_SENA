package com.sena.apisenaspring.dto

import jakarta.persistence.Column
import java.util.UUID


data class ClientDTO(
    val clientId: String?,
    val cedula: String,
    val name: String,
    val address: String,
    val phone: String,
    val email: String
)
