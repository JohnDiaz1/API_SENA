package com.sena.apisenaspring.controller

import com.sena.apisenaspring.dto.InventoryDTO
import com.sena.apisenaspring.service.inventory.InventoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class InventoryController(
    private val inventoryService: InventoryService
) {
    @GetMapping("/items")
    fun getItems(): ResponseEntity<List<InventoryDTO>> {
        return ResponseEntity.ok(inventoryService.getAllInventory())
    }

    @PostMapping("/additem")
    fun addItem(@RequestBody inventoryDTO: InventoryDTO): ResponseEntity<InventoryDTO> {
        return ResponseEntity(inventoryService.addItemToInventory(inventoryDTO), HttpStatus.CREATED)
    }

    @DeleteMapping("/deleteItem/{itemId}")
    fun deleteItem(@PathVariable itemId: String): ResponseEntity<Unit> {
        return ResponseEntity(inventoryService.deleteItem(itemId), HttpStatus.NO_CONTENT)
    }

}