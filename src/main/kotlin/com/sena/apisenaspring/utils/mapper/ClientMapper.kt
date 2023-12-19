package com.sena.apisenaspring.utils.mapper

import com.sena.apisenaspring.dto.ClientDTO
import com.sena.apisenaspring.model.Client
import org.springframework.stereotype.Service

@Service
class ClientMapper: Mapper<ClientDTO, Client> {

    override fun fromEntity(entity: Client): ClientDTO {
        return ClientDTO(
            entity.clientId,
            entity.cedula,
            entity.name,
            entity.address,
            entity.phone,
            entity.email
        )
    }

    override fun toEntity(domain: ClientDTO): Client {
        return Client(
                domain.clientId,
            domain.cedula,
            domain.name,
            domain.address,
            domain.phone,
            domain.email
        )
    }
}