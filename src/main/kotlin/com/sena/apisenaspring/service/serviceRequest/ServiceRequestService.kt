package com.sena.apisenaspring.service.serviceRequest

import com.sena.apisenaspring.dto.ClientDTO
import com.sena.apisenaspring.dto.ServiceRequestDTO

interface ServiceRequestService {

    fun getRequestByClientId(clientId: String): List<ServiceRequestDTO>
    fun getRequests(): List<ServiceRequestDTO>
    //fun getRequestByState(state: String): List<ServiceRequestDTO>
    fun createRequest(requestDTO: ServiceRequestDTO): ServiceRequestDTO
    fun deleteRequest(requestId: String)

}