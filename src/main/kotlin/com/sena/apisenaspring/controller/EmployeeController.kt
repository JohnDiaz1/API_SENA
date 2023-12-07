package com.sena.apisenaspring.controller

import com.sena.apisenaspring.dto.ClientDTO
import com.sena.apisenaspring.dto.EmployeeDTO
import com.sena.apisenaspring.service.employee.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController(
    private val employeeService: EmployeeService
) {
    @GetMapping("/employees")
    fun getClients(): ResponseEntity<List<EmployeeDTO>> {
        return ResponseEntity.ok(employeeService.getEmployees())
    }

    @PostMapping("/addEmployee")
    fun createClient(@RequestBody employeeDTO: EmployeeDTO): ResponseEntity<EmployeeDTO> {
        return ResponseEntity(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED)
    }

    @DeleteMapping("deleteEmployee/{employeeId}")
    fun deleteEmployee(@PathVariable employeeId: String): ResponseEntity<Unit> {
        return ResponseEntity(employeeService.deleteEmployee(employeeId), HttpStatus.NO_CONTENT)
    }

}