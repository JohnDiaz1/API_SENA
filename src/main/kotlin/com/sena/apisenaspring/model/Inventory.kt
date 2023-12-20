package com.sena.apisenaspring.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import javax.annotation.processing.Generated

@Entity
class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var inventoryId: String? = null
    var name: String = ""
    var description: String = ""
    var stock: Int = 0
    var precioCompra: Double = 0.0
    var precioVenta: Double = 0.0

    constructor() {}

    constructor(inventoryId: String?, name: String, description: String, stock: Int, precioCompra: Double, precioVenta: Double) {
        this.inventoryId = inventoryId
        this.name = name
        this.description = description
        this.stock = stock
        this.precioCompra = precioCompra
        this.precioVenta = precioVenta
    }
    constructor(name: String, description: String, stock: Int, precioCompra: Double, precioVenta: Double) {
        this.name = name
        this.description = description
        this.stock = stock
        this.precioCompra = precioCompra
        this.precioVenta = precioVenta
    }

}