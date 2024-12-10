package org.example.dp_project.repository;

import org.example.database_project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Course c WHERE c.id = ?1")
    boolean isIdExist(Long id);
    @Query("SELECT c FROM Course c WHERE c.id = ?1")
    Optional<Course> findById(Long id);
    @Query("SELECT c FROM Course c WHERE c.title LIKE %?1%")
    List<Course> findByNameContains(String title);
    @Query("SELECT c FROM Course c WHERE c.courseCategory.id = (SELECT id FROM Category WHERE name = ?1)")
    List<Course> findCoursesByCategoryName(String categoryName);
    @Query("SELECT c FROM Course c WHERE c.courseInstructor.id = (SELECT id FROM Instructor WHERE name = ?1)")
    List<Course> findCoursesByInstructorName(String instructorName);
    @Query("SELECT c FROM Course c JOIN Enrollment e ON c.id = e.enrollmentCourse.id WHERE e.enrollmentStudent.id = ?1")
    List<Course> findCourseByStudentId(Long studentId);
}
