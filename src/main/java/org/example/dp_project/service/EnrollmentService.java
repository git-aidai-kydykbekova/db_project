package org.example.dp_project.service;


import org.example.dp_project.dto.EnrollmentDto;
import org.example.dp_project.dto.EnrollmentDtoRequest;
import org.example.dp_project.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment getEnrollmentById(Long id);
    List<EnrollmentDto> getEnrollmentByCourseId(Long courseId);
    List<EnrollmentDto> getEnrollmentByStudentId(Long studentId);
    List<EnrollmentDto> getAllEnrollments();

    EnrollmentDto createEnrollment(EnrollmentDtoRequest enrollmentDtoRequest);

    List<EnrollmentDto> sortByEnrollmentDate(List<EnrollmentDto> enrollmentDtoList);
    List<EnrollmentDto> sortByCompletionStatus(Boolean completionStatus, List<EnrollmentDto> enrollmentDtoList);
}
