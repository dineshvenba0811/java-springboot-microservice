package com.dinesh.org.employeeservice.service;

import com.dinesh.org.employeeservice.dto.APIResponseDto;
import com.dinesh.org.employeeservice.dto.EmployeeDto;
import com.dinesh.org.employeeservice.dto.DepartmentDto;
import com.dinesh.org.employeeservice.entity.EmployeeEntity;
import com.dinesh.org.employeeservice.mapper.EmployeeMapper;
import com.dinesh.org.employeeservice.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private APIClient apiclient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity =EmployeeMapper.mapToEntity(employeeDto);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(employeeEntity);
        return EmployeeMapper.mapToDto(savedEmployeeEntity);
    }


    //@CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployee(Long employeeId) {


        EmployeeEntity employeeEntity =employeeRepository.findById(employeeId).get();
        DepartmentDto departmentdto=apiclient.getDepartment(employeeEntity.getDepartmentCode());
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(EmployeeMapper.mapToDto(employeeEntity));
        apiResponseDto.setDepartmentDto(departmentdto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId,Exception exception) {
        EmployeeEntity employeeEntity =employeeRepository.findById(employeeId).get();
        DepartmentDto departmentdto=new DepartmentDto();
        departmentdto.setDepartmentCode("EEP05");
        departmentdto.setDepartmentName("EEP");
        departmentdto.setDepartmentDescription(" autosar configurations");
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployeeDto(EmployeeMapper.mapToDto(employeeEntity));
        apiResponseDto.setDepartmentDto(departmentdto);
        return apiResponseDto;
    }
}
