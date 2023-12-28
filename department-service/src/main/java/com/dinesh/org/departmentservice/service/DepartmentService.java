package com.dinesh.org.departmentservice.service;

import com.dinesh.org.departmentservice.dto.DepartmentDto;
import com.dinesh.org.departmentservice.repository.DepartmentRepository;

public interface DepartmentService {



    DepartmentDto saveDepartment(DepartmentDto dto);

    DepartmentDto getDepartmentByCode(String departmentName);
}
