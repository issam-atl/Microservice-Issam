package com.issam.department.repositories;

import com.issam.department.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepCode(String code);
}
