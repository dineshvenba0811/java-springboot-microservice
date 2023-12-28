package com.dinesh.org.departmentservice.service;

import com.dinesh.org.departmentservice.dto.DepartmentDto;
import com.dinesh.org.departmentservice.entity.DepartmentEntity;
import com.dinesh.org.departmentservice.mapper.DepartmentMapper;
import com.dinesh.org.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepo;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto dto) {
        DepartmentEntity departmentEntity=DepartmentMapper.mapToDepartmentEntity(dto);
        DepartmentEntity savedDepartmentEntity=departmentRepo.save(departmentEntity);
        return DepartmentMapper.mapToDepartmentDto(savedDepartmentEntity);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentName) {
        DepartmentEntity departmentEntity=departmentRepo.findByDepartmentCode(departmentName);
        return DepartmentMapper.mapToDepartmentDto(departmentEntity);
    }
}
