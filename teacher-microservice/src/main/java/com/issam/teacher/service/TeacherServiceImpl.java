package com.issam.teacher.service;

import com.issam.teacher.dto.APIResponseDto;
import com.issam.teacher.dto.DepartmentDto;
import com.issam.teacher.dto.TeacherDto;
import com.issam.teacher.entities.Teacher;
import com.issam.teacher.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;
    private APIClient apiClient;

    @Override
    public APIResponseDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();


        DepartmentDto departmentDto = apiClient.getDepByCode(teacher.getDepCode());
        TeacherDto teacherDto = new TeacherDto(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getDepCode(),
                departmentDto.getDepName()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setTeacherDto(teacherDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
