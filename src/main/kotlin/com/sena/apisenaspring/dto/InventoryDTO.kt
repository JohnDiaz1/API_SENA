package com.sena.apisenaspring.dto

data class InventoryDTO(
    val inventoryId: String?,
    val name: String,
    val description: String,
    val stock: Int,
    val precioCompra: Double,
    val precioVenta: Double,
)
