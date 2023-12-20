package com.sena.apisenaspring.utils.mapper

import com.sena.apisenaspring.dto.ServiceRequestDTO
import com.sena.apisenaspring.model.ServiceRequest
import org.springframework.stereotype.Service

@Service
class ServiceRequestMapper: Mapper<ServiceRequestDTO, ServiceRequest> {

    override fun fromEntity(entity: ServiceRequest): ServiceRequestDTO {
        return ServiceRequestDTO(
            entity.requestId,
            entity.clientId,
            entity.description,
            entity.requestDate,
            entity.state
        )
    }

    override fun toEntity(domain: ServiceRequestDTO): ServiceRequest {
        return ServiceRequest(
                domain.requestId,
            domain.clientId,
            domain.description,
            domain.requestDate,
            domain.state
        )
    }
}