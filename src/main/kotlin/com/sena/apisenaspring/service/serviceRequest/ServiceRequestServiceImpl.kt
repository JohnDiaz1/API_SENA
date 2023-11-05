package com.sena.apisenaspring.service.serviceRequest

import com.sena.apisenaspring.dto.ServiceRequestDTO
import com.sena.apisenaspring.repository.ServiceRequestRepository
import com.sena.apisenaspring.utils.mapper.ServiceRequestMapper
import org.springframework.stereotype.Service

@Service
class ServiceRequestServiceImpl(
    private val serviceRequestRepository: ServiceRequestRepository,
    private val serviceRequestMapper: ServiceRequestMapper
) : ServiceRequestService {

    override fun getRequestByClientId(clientId: String): List<ServiceRequestDTO> {
        val clientRequest = serviceRequestRepository.getAllRequestByClient(clientId)
        return clientRequest.map {
            serviceRequestMapper.fromEntity(it)
        }
    }

    override fun getRequests(): List<ServiceRequestDTO> {
        val requests = serviceRequestRepository.getAllRequest()
        return requests.map {
            serviceRequestMapper.fromEntity(it)
        }
    }

    override fun createRequest(requestDTO: ServiceRequestDTO): ServiceRequestDTO {
        val request = serviceRequestMapper.toEntity(requestDTO)
        serviceRequestRepository.save(request)
        return serviceRequestMapper.fromEntity(request)
    }
}