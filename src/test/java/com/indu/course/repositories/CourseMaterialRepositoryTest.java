package com.indu.course.repositories;

import com.indu.course.domains.Course;
import com.indu.course.domains.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void testCourseMaterialCreation() {
        Course course = Course.builder().courseTitle("Course 1").credit(3).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.test.com").course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }
}