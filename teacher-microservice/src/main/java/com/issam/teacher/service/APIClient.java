package com.issam.teacher.service;

import com.issam.teacher.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepByCode(@PathVariable("department-code") String departmentCode);
}
