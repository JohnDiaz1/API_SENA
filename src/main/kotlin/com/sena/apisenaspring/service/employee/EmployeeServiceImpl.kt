package com.sena.apisenaspring.service.employee

import com.sena.apisenaspring.dto.EmployeeDTO
import com.sena.apisenaspring.repository.EmployeeRepository
import com.sena.apisenaspring.utils.mapper.EmployeeMapper
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(
    private val employeeRepository: EmployeeRepository,
    private val employeeMapper: EmployeeMapper
) : EmployeeService {

    override fun getEmployees(): List<EmployeeDTO> {
        val clients = employeeRepository.getAllEmployees()
        return clients.map {
            employeeMapper.fromEntity(it)
        }
    }

    override fun createEmployee(employeeDTO: EmployeeDTO): EmployeeDTO {
        //No Id?
        val client = employeeMapper.toEntity(employeeDTO)
        employeeRepository.save(client)
        // It will have an ID
        return employeeMapper.fromEntity(client)
    }

    override fun deleteEmployee(employeeId: String) {
        employeeRepository.deleteById(employeeId)
    }
}