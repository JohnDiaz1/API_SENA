package com.sena.apisenaspring.service.employee

import com.sena.apisenaspring.dto.EmployeeDTO

interface EmployeeService {

    //fun getClientByCedula(cedula: String): ClientDTO
    fun getEmployees(): List<EmployeeDTO>
    fun createEmployee(employeeDTO: EmployeeDTO): EmployeeDTO

}