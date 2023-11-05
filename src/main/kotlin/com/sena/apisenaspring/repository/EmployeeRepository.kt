package com.sena.apisenaspring.repository

import com.sena.apisenaspring.model.Employee
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository: CrudRepository<Employee, String> {
    @Query("SELECT e FROM Employee as e")
    fun getAllEmployees(): List<Employee>
}