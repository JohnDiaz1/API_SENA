package com.sena.apisenaspring.utils.mapper

import com.sena.apisenaspring.dto.InventoryDTO
import com.sena.apisenaspring.model.Inventory
import org.springframework.stereotype.Service

@Service
class InventoryMapper: Mapper<InventoryDTO, Inventory> {
    override fun fromEntity(entity: Inventory): InventoryDTO {
        return InventoryDTO(
            entity.inventoryId,
            entity.name,
            entity.description,
            entity.stock,
            entity.precioCompra,
            entity.precioVenta,
        )
    }

    override fun toEntity(domain: InventoryDTO): Inventory {
        return Inventory(
            domain.name,
            domain.description,
            domain.stock,
            domain.precioCompra,
            domain.precioVenta,
        )
    }
}