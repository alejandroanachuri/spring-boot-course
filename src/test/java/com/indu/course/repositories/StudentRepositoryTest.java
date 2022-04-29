package com.indu.course.repositories;

import com.indu.course.domains.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void test_save_student(){
        Student student = Student.builder().email("pepito@gmail.com").firstName("Pepe").lastName("Cuenca").build();
        studentRepository.save(student);

    }

    @Test
    public void get_all_students() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }


}