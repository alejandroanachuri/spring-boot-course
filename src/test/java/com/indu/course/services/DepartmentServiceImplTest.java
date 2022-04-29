package com.indu.course.services;

import com.indu.course.domains.Department;
import com.indu.course.repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentId(1L).departmentName("IT").
                departmentCode("1").departmentAddress("Talcahuano 1335").build();
       Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));

    }

    @Test
    public void test_find_department() {
        Department currentDepartment = departmentService.getDepartmentById(1L);

        assertEquals(currentDepartment.getDepartmentName(), "IT");
    }
}