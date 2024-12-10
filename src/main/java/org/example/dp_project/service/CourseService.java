package org.example.dp_project.service;

import org.example.dp_project.dto.CourseDtoRequest;
import org.example.dp_project.dto.CourseDtoResponse;
import org.example.dp_project.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course getCourseById(Long id);
    Course getCourseEntityByName(String name);
    List<CourseDtoResponse> getCourseByName(String name);
    List<CourseDtoResponse> getAllCourses();
    List<CourseDtoResponse> getCoursesByCategoryName(String categoryName);
    List<CourseDtoResponse> getCoursesByInstructorName(String instructorName);
    List<CourseDtoResponse> getCoursesByStudentName(String studentName);

    CourseDtoResponse createCourse(CourseDtoRequest CourseDto);
    CourseDtoResponse updateCourse(CourseDtoRequest CourseDto);

    List<CourseDtoResponse> sortByDuration();
    List<CourseDtoResponse> sortByPrice();
    List<CourseDtoResponse> sortByEnrollments();
    List<CourseDtoResponse> sortByRating();
}
