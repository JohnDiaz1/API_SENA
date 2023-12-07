package com.sena.apisenaspring.service.inventory

import com.sena.apisenaspring.dto.InventoryDTO

interface InventoryService {
    fun getAllInventory(): List<InventoryDTO>
    fun addItemToInventory(inventoryDTO: InventoryDTO): InventoryDTO
    //fun editItemInventory(): InventoryDTO
    fun deleteItem(itemId: String)
}