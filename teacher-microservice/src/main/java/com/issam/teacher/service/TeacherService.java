package com.issam.teacher.service;

import com.issam.teacher.dto.APIResponseDto;
import com.issam.teacher.dto.TeacherDto;

public interface TeacherService {
    APIResponseDto getTeacherById(Long id);
}
