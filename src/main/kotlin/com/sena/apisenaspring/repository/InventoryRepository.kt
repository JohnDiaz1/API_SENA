package com.sena.apisenaspring.repository

import com.sena.apisenaspring.model.Inventory
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface InventoryRepository: CrudRepository<Inventory, String> {
    @Query("SELECT i FROM Inventory as i ")
    fun getAllItems(): List<Inventory>
}