package com.dinesh.org.departmentservice.mapper;

import com.dinesh.org.departmentservice.dto.DepartmentDto;
import com.dinesh.org.departmentservice.entity.DepartmentEntity;

public class DepartmentMapper {
    public static DepartmentEntity mapToDepartmentEntity(DepartmentDto departmentDto){
        return new DepartmentEntity(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentCode(),
                departmentDto.getDepartmentDescription()
        );
    }
    public static DepartmentDto mapToDepartmentDto(DepartmentEntity departmentEntity){
        return new DepartmentDto(
                departmentEntity.getId(),
                departmentEntity.getDepartmentName(),
                departmentEntity.getDepartmentCode(),
                departmentEntity.getDepartmentDescription()
        );
    }
}
