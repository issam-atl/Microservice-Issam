package com.issam.department.controller;


import com.issam.department.Dto.DepartmentDto;
import com.issam.department.config.Configuration;
import com.issam.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    Configuration configuration;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepByCode(@PathVariable("code")
                                                      String code) {
        return new ResponseEntity<DepartmentDto>(
                departmentService.getDepartmentByCode(code),
                HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public  ResponseEntity<String> retrieveAuthorInfo() {
        return
                ResponseEntity.status(HttpStatus.OK)
                        .body(configuration.getName()+" "+configuration.getEmail() );
    }

}
