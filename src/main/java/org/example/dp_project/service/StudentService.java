package org.example.dp_project.service;


import org.example.database_project.dto.StudentDto;
import org.example.database_project.entity.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long id);
    List<StudentDto> getStudentByName(String name);
    List<StudentDto> getStudentsByCourseId(Long courseId);
    List<StudentDto> getAllStudents();

    StudentDto createStudent(StudentDto instructorDto);
    StudentDto updateStudent(StudentDto instructorDto);
}
