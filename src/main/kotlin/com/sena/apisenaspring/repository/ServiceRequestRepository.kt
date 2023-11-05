package com.sena.apisenaspring.repository

import com.sena.apisenaspring.model.ServiceRequest
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ServiceRequestRepository: CrudRepository<ServiceRequest, String> {

    @Query("SELECT r FROM ServiceRequest as r")
    fun getAllRequest(): List<ServiceRequest>

    @Query("SELECT src FROM ServiceRequest src WHERE src.clientId = :clientId")
    fun getAllRequestByClient(@Param("clientId") clientId: String): List<ServiceRequest>

}