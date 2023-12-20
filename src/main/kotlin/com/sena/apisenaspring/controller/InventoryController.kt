package com.sena.apisenaspring.controller

import com.sena.apisenaspring.dto.InventoryDTO
import com.sena.apisenaspring.service.inventory.InventoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("inventory")
class InventoryController(
    private val inventoryService: InventoryService
) {
    @GetMapping("/items")
    fun getItems(): ResponseEntity<List<InventoryDTO>> {
        return ResponseEntity.ok(inventoryService.getAllInventory())
    }

    @GetMapping("/getItemById/{itemId}")
    fun getItemById(@PathVariable itemId: String): ResponseEntity<InventoryDTO> {
        return ResponseEntity.ok(inventoryService.getItemById(itemId))
    }

    @PostMapping("/addItem")
    fun addItem(@RequestBody inventoryDTO: InventoryDTO): ResponseEntity<InventoryDTO> {
        return ResponseEntity(inventoryService.addItemToInventory(inventoryDTO), HttpStatus.CREATED)
    }

    @PutMapping("/updateItem")
    fun updateItem(@RequestBody inventoryDTO: InventoryDTO): ResponseEntity<InventoryDTO> {
        return ResponseEntity.ok(inventoryService.updateItem(inventoryDTO))
    }

    @DeleteMapping("/deleteItem/{itemId}")
    fun deleteItem(@PathVariable itemId: String): ResponseEntity<Unit> {
        return ResponseEntity(inventoryService.deleteItem(itemId), HttpStatus.NO_CONTENT)
    }

}