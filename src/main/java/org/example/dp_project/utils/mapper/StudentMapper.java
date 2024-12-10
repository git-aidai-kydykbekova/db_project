package org.example.dp_project.utils.mapper;

import org.example.dp_project.dto.StudentDto;
import org.example.dp_project.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentDto entityToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setDateOfBirth(student.getDateOfBirth());
        studentDto.setRegistrationDate(student.getRegistrationDate());
        return studentDto;
    }

    public List<StudentDto> entityToDtoList(List<Student> students) {
        return students.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Student dtoToEntity (StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        return student;
    }
}
