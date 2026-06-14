package com.issam.department.service;

import com.issam.department.Dto.DepartmentDto;
import com.issam.department.entities.Department;
import com.issam.department.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department dep = departmentRepository.findByDepCode(code);
        DepartmentDto departmentDto = new DepartmentDto(
                dep.getId(),
                dep.getDepName(),
                dep.getDepCode()
        );
        return departmentDto;
    }
}
