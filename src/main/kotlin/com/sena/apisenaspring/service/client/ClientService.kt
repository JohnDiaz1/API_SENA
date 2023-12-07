package com.sena.apisenaspring.service.client

import com.sena.apisenaspring.dto.ClientDTO

interface ClientService {

    fun getClientByCedula(cedula: String): ClientDTO

    fun getClientById(clientId: String): ClientDTO
    fun getClients(): List<ClientDTO>
    fun createClient(clientDTO: ClientDTO): ClientDTO

    fun updateClient(clientDTO: ClientDTO): ClientDTO
    fun deleteClient(clientId: String)
}