package com.dinesh.org.departmentservice.repository;

import com.dinesh.org.departmentservice.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

    DepartmentEntity findByDepartmentCode(String departmentCode);
}
