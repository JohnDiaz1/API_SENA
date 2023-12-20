package com.sena.apisenaspring.utils.mapper

import com.sena.apisenaspring.dto.EmployeeDTO
import com.sena.apisenaspring.model.Employee
import org.springframework.stereotype.Service

@Service
class EmployeeMapper: Mapper<EmployeeDTO, Employee> {

    override fun fromEntity(entity: Employee): EmployeeDTO {
        return EmployeeDTO(
            entity.employeeId,
            entity.name,
            entity.phone,
            entity.position,
            entity.state
        )
    }

    override fun toEntity(domain: EmployeeDTO): Employee {
        return Employee(
                domain.employeeId,
            domain.name,
            domain.phone,
            domain.position,
            domain.state
        )
    }
}