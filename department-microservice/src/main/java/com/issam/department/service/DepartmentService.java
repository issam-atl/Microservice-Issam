package com.issam.department.service;

import com.issam.department.Dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto getDepartmentByCode(String code);
}
