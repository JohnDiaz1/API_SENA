package com.sena.apisenaspring.service.client

import com.sena.apisenaspring.dto.ClientDTO

interface ClientService {

    fun getClientByCedula(cedula: String): ClientDTO
    fun getClients(): List<ClientDTO>
    fun createClient(clientDTO: ClientDTO): ClientDTO

}