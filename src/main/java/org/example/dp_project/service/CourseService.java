package org.example.dp_project.service;

import org.example.dp_project.dto.CourseDtoRequest;
import org.example.dp_project.dto.CourseDtoResponse;
import org.example.dp_project.entity.Course;

import java.util.List;

public interface CourseService {
    Course getCourseById(Long id);
    List<CourseDtoResponse> getCourseByName(String name);
    List<CourseDtoResponse> getAllCourses();
    List<CourseDtoResponse> getCoursesByCategoryName(String categoryName);
    List<CourseDtoResponse> getCoursesByInstructorName(String instructorName);
    List<CourseDtoResponse> getCoursesByStudentId(Long studentId);

    CourseDtoResponse createCourse(CourseDtoRequest CourseDto);
    CourseDtoResponse updateCourse(CourseDtoRequest CourseDto);

    List<CourseDtoResponse> sortByDuration(List<CourseDtoResponse> courseDtoResponseList);
    List<CourseDtoResponse> sortByPrice(List<CourseDtoResponse> courseDtoResponseList);
    List<CourseDtoResponse> sortByEnrollments(List<CourseDtoResponse> courseDtoResponseList);
    List<CourseDtoResponse> sortByRating(List<CourseDtoResponse> courseDtoResponseList);
}
