package org.example.dp_project.dto;

import java.time.LocalDate;

public class EnrollmentDtoRequest {
    private Long id;
    private LocalDate enrollmentDate;
    private Boolean completionStatus;
    private Long studentId;
    private Long courseId;

    public EnrollmentDtoRequest() {}

    public Long getId() {
        return id;
    }

    public EnrollmentDtoRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public EnrollmentDtoRequest setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
        return this;
    }

    public Boolean getCompletionStatus() {
        return completionStatus;
    }

    public EnrollmentDtoRequest setCompletionStatus(Boolean completionStatus) {
        this.completionStatus = completionStatus;
        return this;
    }

    public Long getStudentId() {
        return studentId;
    }

    public EnrollmentDtoRequest setStudentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public Long getCourseId() {
        return courseId;
    }

    public EnrollmentDtoRequest setCourseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }
}
