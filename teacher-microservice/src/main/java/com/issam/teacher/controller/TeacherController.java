package com.issam.teacher.controller;

import com.issam.teacher.dto.TeacherDto;
import com.issam.teacher.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teachers")
@AllArgsConstructor
public class TeacherController {
    private TeacherService teachersService;

    @GetMapping("{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("id")
                                                     Long id )
    {
        return  new ResponseEntity<TeacherDto>(
                teachersService.getTeacherById(id), HttpStatus.OK);
    }
}
