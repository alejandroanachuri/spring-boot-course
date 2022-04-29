package com.indu.course.controllers;

import com.indu.course.domains.Department;
import com.indu.course.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setup(){
        department = Department.builder().departmentName("Department 23").departmentId(1L).
                departmentAddress("Talcahuano 1335").departmentCode("DEP23").build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department departmentInput = Department.builder().departmentName("Department 23").departmentId(1L).
                departmentAddress("Talcahuano 1335").departmentCode("DEP23").build();

        Mockito.when(departmentService.saveDepartment(departmentInput)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "\t\"departmentName\":\"Department 23\",\n" +
                    "\t\"departmentAddress\":\"Talcahuano 1335\",\n" +
                    "\t\"departmentCode\":\"DEP23\"\n" +
                    "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}