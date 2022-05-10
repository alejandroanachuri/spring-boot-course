package com.indu.course.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*
    @SecuenceGenerator(
        name= "course_material_sequence",
        sequenceName= "course_material_sequence",
        allocationSize=1
     )

     @GeneratedValue(
        strategy= GenerationType.SQQUENCE,
        generator= "course_material_sequence"
     )
     */
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name="course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
