package com.sena.apisenaspring.service.serviceRequest

import com.sena.apisenaspring.dto.InventoryDTO
import com.sena.apisenaspring.dto.ServiceRequestDTO
import com.sena.apisenaspring.repository.ServiceRequestRepository
import com.sena.apisenaspring.utils.exceptions.ClientException
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

    override fun getRequestById(requestId: String): ServiceRequestDTO {
        val optionalRequest = serviceRequestRepository.findById(requestId)
        val request = optionalRequest.orElseThrow { ClientException("Item con id $requestId no existe") }
        return serviceRequestMapper.fromEntity(request)
    }

    override fun createRequest(requestDTO: ServiceRequestDTO): ServiceRequestDTO {
        val request = serviceRequestMapper.toEntity(requestDTO)
        serviceRequestRepository.save(request)
        return serviceRequestMapper.fromEntity(request)
    }

    override fun updateRequest(requestDTO: ServiceRequestDTO): ServiceRequestDTO {
        requestDTO.requestId?.let { getRequestById(it) }
        serviceRequestRepository.save(serviceRequestMapper.toEntity(requestDTO))
        return requestDTO
    }

    override fun deleteRequest(requestId: String) {
        serviceRequestRepository.deleteById(requestId)
    }
}