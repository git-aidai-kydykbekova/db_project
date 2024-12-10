package org.example.dp_project.utils.mapper;

import org.example.database_project.dto.EnrollmentDto;
import org.example.database_project.dto.EnrollmentDtoRequest;
import org.example.database_project.entity.Enrollment;
import org.example.database_project.service.CourseService;
import org.example.database_project.service.StudentService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnrollmentMapper {
    private CourseService courseService;
    private StudentService studentService;

    public EnrollmentMapper(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public EnrollmentDto entityToDto(Enrollment enrollment) {
        EnrollmentDto enrollmentDto = new EnrollmentDto();
        enrollmentDto.setId(enrollment.getId());
        enrollmentDto.setEnrollmentDate(enrollment.getEnrollmentDate());
        enrollmentDto.setCompletionStatus(enrollment.getCompletionStatus());
        enrollmentDto.setCourseId(enrollment.getEnrollmentCourse().getId());
        enrollmentDto.setCourseName(enrollment.getEnrollmentCourse().getTitle());
        enrollmentDto.setStudentId(enrollment.getEnrollmentStudent().getId());
        enrollmentDto.setCourseCategory(enrollment.getEnrollmentCourse().getCourseCategory().getName());
        enrollmentDto.setStudentName(enrollment.getEnrollmentStudent().getName());
        return enrollmentDto;
    }

    public List<EnrollmentDto> entityToDtoList(List<Enrollment> enrollments) {
        return enrollments.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Enrollment dtoToEntity (EnrollmentDtoRequest enrollmentDtoRequest) {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(enrollmentDtoRequest.getId());
        enrollment.setEnrollmentDate(enrollmentDtoRequest.getEnrollmentDate());
        enrollment.setEnrollmentDate(enrollmentDtoRequest.getEnrollmentDate());
        enrollment.setCompletionStatus(enrollmentDtoRequest.getCompletionStatus());
        enrollment.setEnrollmentCourse(courseService.getCourseById(enrollmentDtoRequest.getCourseId()));
        enrollment.setEnrollmentStudent(studentService.getStudentById(enrollmentDtoRequest.getStudentId()));
        return enrollment;
    }
}
