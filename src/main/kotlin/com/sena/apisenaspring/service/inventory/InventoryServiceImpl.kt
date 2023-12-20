package com.sena.apisenaspring.service.inventory

import com.sena.apisenaspring.dto.InventoryDTO
import com.sena.apisenaspring.repository.InventoryRepository
import com.sena.apisenaspring.utils.exceptions.ClientException
import com.sena.apisenaspring.utils.mapper.InventoryMapper
import org.springframework.stereotype.Service

@Service
class InventoryServiceImpl(
    private val inventoryRepository: InventoryRepository,
    private val inventoryMapper: InventoryMapper
) : InventoryService {

    override fun getAllInventory(): List<InventoryDTO> {
        val inventory = inventoryRepository.getAllItems()
        return inventory.map {
            inventoryMapper.fromEntity(it)
        }
    }

    override fun getItemById(itemId: String): InventoryDTO {
        val optionalItem = inventoryRepository.findById(itemId)
        val item = optionalItem.orElseThrow { ClientException("Item con id $itemId no existe") }
        return inventoryMapper.fromEntity(item)
    }

    override fun addItemToInventory(inventoryDTO: InventoryDTO): InventoryDTO {
        val item = inventoryMapper.toEntity(inventoryDTO)
        inventoryRepository.save(item)
        return inventoryMapper.fromEntity(item)
    }

    override fun updateItem(inventoryDTO: InventoryDTO): InventoryDTO {
        inventoryDTO.inventoryId?.let { getItemById(it) }
        inventoryRepository.save(inventoryMapper.toEntity(inventoryDTO))
        return inventoryDTO
    }

    override fun deleteItem(inventoryId: String) {
        inventoryRepository.deleteById(inventoryId)
    }
}