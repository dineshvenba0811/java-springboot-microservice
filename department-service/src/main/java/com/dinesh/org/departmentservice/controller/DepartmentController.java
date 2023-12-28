package com.dinesh.org.departmentservice.controller;

import com.dinesh.org.departmentservice.dto.DepartmentDto;
import com.dinesh.org.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/departments/")
public class DepartmentController {

    private DepartmentService service;
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
       DepartmentDto savedDepartment= service.saveDepartment(departmentDto);
       return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{getDepartmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("getDepartmentCode") String departmentName){
        DepartmentDto getDepartment=service.getDepartmentByCode(departmentName);
        return  new ResponseEntity<>(getDepartment,HttpStatus.OK);
    }
}
