package org.example.dp_project.controller;

import org.example.dp_project.dto.*;
import org.example.dp_project.service.CourseService;
import org.example.dp_project.utils.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(value = "/get-course-by-name/{courseName}")
    public ResponseEntity<Response> getCourseByName(@PathVariable String courseName) {
        try {
            return ResponseEntity.ok(new Response("Successfully get Course.", courseService.getCourseByName(courseName)));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Failed to get Course. " + exception.getMessage(), null));
        }
    }

    @GetMapping("/get-all-course")
    public ResponseEntity<Response> getAllCourse() {
        try {
            courseService.getAllCourses();
            return ResponseEntity.ok(new Response("Successfully got all Courses.", courseService.getAllCourses()));
        } catch (ObjectNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Couldn't find. " + exception.getMessage(), null));
        }
    }

    @GetMapping(value = "/get-course-by-category-name/{categoryName}")
    public ResponseEntity<Response> getCourseByCategoryName(@PathVariable String categoryName) {
        try {
            return ResponseEntity.ok(new Response("Successfully get Courses.", courseService.getCoursesByCategoryName(categoryName)));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Failed to get Courses. " + exception.getMessage(), null));
        }
    }

    @GetMapping(value = "/get-course-by-instructor-name/{instructorName}")
    public ResponseEntity<Response> getCourseByInstructorName(@PathVariable String instructorName) {
        try {
            return ResponseEntity.ok(new Response("Successfully get Courses.", courseService.getCoursesByInstructorName(instructorName)));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Failed to get Courses. " + exception.getMessage(), null));
        }
    }

    @GetMapping(value = "/get-course-by-student-ig/{studentId}")
    public ResponseEntity<Response> getCourseByStudentId(@PathVariable Long studentId) {
        try {
            return ResponseEntity.ok(new Response("Successfully get Courses.", courseService.getCoursesByStudentId(studentId)));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Failed to get Courses. " + exception.getMessage(), null));
        }
    }

    @PostMapping(value = "/create-course")
    public ResponseEntity<Response> createCourse(@RequestBody CourseDtoRequest request) {
        try {
            CourseDtoResponse courseDtoResponse = courseService.createCourse(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Successfully created Course.", courseDtoResponse));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Course is not saved. " + exception.getMessage(), null));
        }
    }

    @PutMapping(value = "/update-course")
    public ResponseEntity<Response> updateCourse(@RequestBody CourseDtoRequest request) {
        try {
            CourseDtoResponse courseDtoResponse = courseService.updateCourse(request);
            return ResponseEntity.ok(new Response("Updated Course successfully.", courseDtoResponse));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Course is not updated. " + exception.getMessage(), null));
        }
    }

    @GetMapping(value = "/sort-by-duration")
    public ResponseEntity<Response> sortByDuration(@RequestBody List<CourseDtoResponse> courseDtoResponses) {
        try {
            return ResponseEntity.ok(new Response("Successfully get Courses.", courseService.sortByDuration(courseDtoResponses)));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Failed to get Courses. " + exception.getMessage(), null));
        }
    }

    @GetMapping(value = "/sort-by-price")
    public ResponseEntity<Response> sortByPrice(@RequestBody List<CourseDtoResponse> courseDtoResponses) {
        try {
            return ResponseEntity.ok(new Response("Successfully get Courses.", courseService.sortByPrice(courseDtoResponses)));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Failed to get Courses. " + exception.getMessage(), null));
        }
    }

    @GetMapping(value = "/sort-by-enrollments")
    public ResponseEntity<Response> sortByEnrollments(@RequestBody List<CourseDtoResponse> courseDtoResponses) {
        try {
            return ResponseEntity.ok(new Response("Successfully get Courses.", courseService.sortByEnrollments(courseDtoResponses)));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Failed to get Courses. " + exception.getMessage(), null));
        }
    }

    @GetMapping(value = "/sort-by-rating")
    public ResponseEntity<Response> sortByRating(@RequestBody List<CourseDtoResponse> courseDtoResponses) {
        try {
            return ResponseEntity.ok(new Response("Successfully get Courses.", courseService.sortByRating(courseDtoResponses)));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Failed to get Courses. " + exception.getMessage(), null));
        }
    }
}
