package com.sena.apisenaspring.controller

import com.sena.apisenaspring.dto.ClientDTO
import com.sena.apisenaspring.service.client.ClientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ClientController (
    private val clientService: ClientService
) {

    @GetMapping("/client/{cedula}")
    fun getClientByCedula(@PathVariable cedula: String): ResponseEntity<ClientDTO> {
        return ResponseEntity.ok(clientService.getClientByCedula(cedula))
    }

    @GetMapping("/clients")
    fun getClients(): ResponseEntity<List<ClientDTO>> {
        return ResponseEntity.ok(clientService.getClients())
    }

    @PostMapping("/addclient")
    fun createClient(@RequestBody clientDTO: ClientDTO): ResponseEntity<ClientDTO> {
            return ResponseEntity(clientService.createClient(clientDTO), HttpStatus.CREATED)
    }
}