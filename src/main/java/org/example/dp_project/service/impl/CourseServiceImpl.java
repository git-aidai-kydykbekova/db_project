package org.example.dp_project.service.impl;

import org.example.dp_project.dto.CourseDtoRequest;
import org.example.dp_project.dto.CourseDtoResponse;
import org.example.dp_project.entity.Course;
import org.example.dp_project.repository.CourseRepository;
import org.example.dp_project.service.CourseService;
import org.example.dp_project.utils.exception.AlreadyExistException;
import org.example.dp_project.utils.exception.ObjectNotFoundException;
import org.example.dp_project.utils.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    private boolean isIdExist(Long id) {
        if (courseRepository.existsById(id))
            throw new AlreadyExistException("Course", "id");
        return false;
    }

    private Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Course"));
    }

    @Override
    public Course getCourseEntityByName(String name) {
        return courseRepository.findByName(name)
                .orElseThrow(() -> new ObjectNotFoundException("Course"));
    }

    @Override
    public List<CourseDtoResponse> getCourseByName(String name) {
        return courseMapper.entityToDtoList(courseRepository.findByNameContains(name));
    }

    @Override
    public List<CourseDtoResponse> getAllCourses() {
        return courseMapper.entityToDtoList(courseRepository.findAll());
    }

    @Override
    public List<CourseDtoResponse> getCoursesByCategoryName(String categoryName) {
        return courseMapper.entityToDtoList(courseRepository.findCoursesByCategoryName(categoryName));
    }

    @Override
    public List<CourseDtoResponse> getCoursesByInstructorName(String instructorName) {
        return courseMapper.entityToDtoList(courseRepository.findCoursesByInstructorName(instructorName));
    }

    @Override
    public List<CourseDtoResponse> getCoursesByStudentName(String studentName) {
        return courseMapper.entityToDtoList(courseRepository.findCourseByStudentName(studentName));
    }

    @Override
    public CourseDtoResponse createCourse(CourseDtoRequest courseDtoRequest) {
        Course course = courseMapper.dtoToEntity(courseDtoRequest);
        course.setAverageRating(0.0F);
        course.setTotalEnrollments(0);
        return courseMapper.entityToDto(save(course));
    }

    @Override
    public CourseDtoResponse updateCourse(CourseDtoRequest courseDtoRequest) {
        Course oldCourse = courseMapper.dtoToEntity(courseDtoRequest);
        Course newCourse = getCourseById(courseDtoRequest.getId());

        if (!(oldCourse.getTitle() == null))
            newCourse.setTitle(oldCourse.getTitle());
        if (!(oldCourse.getDescription() == null))
            newCourse.setDescription(oldCourse.getDescription());
        if (!(oldCourse.getDuration() == null))
            newCourse.setDuration(oldCourse.getDuration());
        if (!(oldCourse.getPrice() == null))
            newCourse.setPrice(oldCourse.getPrice());
        if (!(oldCourse.getInstructor() == null))
            newCourse.setInstructor(oldCourse.getInstructor());
        if (!(oldCourse.getCategory() == null))
            newCourse.setCategory(oldCourse.getCategory());

        return courseMapper.entityToDto(save(newCourse));
    }

    @Override
    public List<CourseDtoResponse> sortByDuration() {
        return getAllCourses().stream()
                .sorted(Comparator.comparingInt(CourseDtoResponse::getDuration))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDtoResponse> sortByPrice() {
        return getAllCourses().stream()
                .sorted(Comparator.comparingDouble(CourseDtoResponse::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDtoResponse> sortByEnrollments() {
        return getAllCourses().stream()
                .sorted(Comparator.comparingInt(CourseDtoResponse::getTotalEnrollments))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDtoResponse> sortByRating() {
        return getAllCourses().stream()
                .sorted(Comparator.comparingDouble(CourseDtoResponse::getAverageRating).reversed())
                .collect(Collectors.toList());
    }
}
