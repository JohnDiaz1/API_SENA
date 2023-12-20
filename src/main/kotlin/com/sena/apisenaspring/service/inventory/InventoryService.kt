package com.sena.apisenaspring.service.inventory

import com.sena.apisenaspring.dto.InventoryDTO

interface InventoryService {
    fun getAllInventory(): List<InventoryDTO>
    fun getItemById(itemId: String): InventoryDTO
    fun addItemToInventory(inventoryDTO: InventoryDTO): InventoryDTO
    fun updateItem(inventoryDTO: InventoryDTO): InventoryDTO
    fun deleteItem(itemId: String)
}