package com.sena.apisenaspring.repository

import com.sena.apisenaspring.dto.ClientDTO
import com.sena.apisenaspring.model.Client
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface ClientRepository: CrudRepository<Client, String> {

    //fun createClient(clientDTO: ClientDTO)
    @Query("SELECT c from Client as c ")
    fun getAllClients(): List<Client>
}