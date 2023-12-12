package com.sena.apisenaspring.controller

import com.sena.apisenaspring.dto.ServiceRequestDTO
import com.sena.apisenaspring.service.serviceRequest.ServiceRequestService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("serviceRequest")
class ServiceRequestController(
    private val serviceRequestService: ServiceRequestService
) {

    @GetMapping("/requests")
    fun getRequests(): ResponseEntity<List<ServiceRequestDTO>>{
        return ResponseEntity.ok(serviceRequestService.getRequests())
    }

    @GetMapping("/requests/{clientId}")
    fun getRequestsByClient(@PathVariable clientId: String): ResponseEntity<List<ServiceRequestDTO>> {
        return ResponseEntity.ok(serviceRequestService.getRequestByClientId(clientId))
    }

    @PostMapping("/addRequest")
    fun createRequest(@RequestBody serviceRequestDTO: ServiceRequestDTO): ResponseEntity<ServiceRequestDTO> {
        return ResponseEntity(serviceRequestService.createRequest(serviceRequestDTO), HttpStatus.CREATED)
    }

    @PutMapping("/updateRequest")
    fun updateRequest(@RequestBody serviceRequestDTO: ServiceRequestDTO): ResponseEntity<ServiceRequestDTO> {
        return ResponseEntity.ok(serviceRequestService.updateRequest(serviceRequestDTO))
    }

    @DeleteMapping("/deleteRequest/{requestId}")
    fun deleteRequestById(@PathVariable requestId: String): ResponseEntity<Unit> {
        return ResponseEntity(serviceRequestService.deleteRequest(requestId), HttpStatus.NO_CONTENT)
    }

}