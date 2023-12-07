package com.sena.apisenaspring.service.client

import com.sena.apisenaspring.dto.ClientDTO
import com.sena.apisenaspring.repository.ClientRepository
import com.sena.apisenaspring.utils.exceptions.ClientException
import com.sena.apisenaspring.utils.mapper.ClientMapper
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl(
    private val clientRepository: ClientRepository,
    private val clientMapper: ClientMapper
) : ClientService {

    override fun getClientByCedula(cedula: String): ClientDTO {
        return clientMapper.fromEntity(clientRepository.findById(cedula).get())
    }

    override fun getClientById(clientId: String): ClientDTO {
        val optionalClient = clientRepository.findById(clientId)
        val client = optionalClient.orElseThrow { ClientException("Client con id $clientId no exist") }
        return clientMapper.fromEntity(client)
    }

    override fun getClients(): List<ClientDTO> {
        val clients = clientRepository.getAllClients()
        return clients.map {
            clientMapper.fromEntity(it)
        }
    }

    override fun createClient(clientDTO: ClientDTO): ClientDTO {
        //No Id?
        val client = clientMapper.toEntity(clientDTO)
        clientRepository.save(client)
        // It will have an ID
        return clientMapper.fromEntity(client)
    }

    override fun updateClient(clientDTO: ClientDTO): ClientDTO {
        clientDTO.clientId?.let { getClientById(it) }
        clientRepository.save(clientMapper.toEntity(clientDTO))
        return clientDTO
    }

    override fun deleteClient(clientId: String) {
        clientRepository.deleteById(clientId)
    }
}