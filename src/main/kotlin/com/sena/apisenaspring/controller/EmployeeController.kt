package com.sena.apisenaspring.controller

import com.sena.apisenaspring.dto.ClientDTO
import com.sena.apisenaspring.dto.EmployeeDTO
import com.sena.apisenaspring.service.employee.EmployeeService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("employee")
class EmployeeController(
    private val employeeService: EmployeeService
) {
    @GetMapping("/employees")
    fun getEmployees(): ResponseEntity<List<EmployeeDTO>> {
        return ResponseEntity.ok(employeeService.getEmployees())
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    fun getEmployeeById(@PathVariable employeeId: String): ResponseEntity<EmployeeDTO> {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId))
    }

    @PostMapping("/addEmployee")
    fun createEmployee(@RequestBody employeeDTO: EmployeeDTO): ResponseEntity<EmployeeDTO> {
        return ResponseEntity(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED)
    }

    @PutMapping("/updateEmployee")
    fun updateEmployee(@RequestBody employeeDTO: EmployeeDTO): ResponseEntity<EmployeeDTO> {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDTO))
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    fun deleteEmployee(@PathVariable employeeId: String): ResponseEntity<Unit> {
        return ResponseEntity(employeeService.deleteEmployee(employeeId), HttpStatus.NO_CONTENT)
    }

}