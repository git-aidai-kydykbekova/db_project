package org.example.dp_project.utils.mapper;

import org.example.database_project.dto.FeedbackDto;
import org.example.database_project.dto.FeedbackDtoRequest;
import org.example.database_project.entity.Feedback;
import org.example.database_project.service.CourseService;
import org.example.database_project.service.StudentService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FeedbackMapper {
    private CourseService courseService;
    private StudentService studentService;

    public FeedbackMapper(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public FeedbackDto entityToDto(Feedback feedback) {
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setId(feedback.getId());
        feedbackDto.setComment(feedback.getComment());
        feedbackDto.setFeedbackDate(feedback.getFeedbackDate());
        feedbackDto.setRating(feedback.getRating());
        feedbackDto.setCourseId(feedback.getFeedbackCourse().getId());
        feedbackDto.setCourseName(feedback.getFeedbackCourse().getTitle());
        feedbackDto.setStudentId(feedback.getFeedbackStudent().getId());
        feedbackDto.setStudentName(feedback.getFeedbackStudent().getName());
        return feedbackDto;
    }

    public List<FeedbackDto> entityToDtoList(List<Feedback> feedbacks) {
        return feedbacks.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Feedback dtoToEntity (FeedbackDtoRequest feedbackDtoRequest) {
        Feedback feedback = new Feedback();
        feedback.setId(feedbackDtoRequest.getId());
        feedback.setComment(feedbackDtoRequest.getComment());
        feedback.setFeedbackDate(feedbackDtoRequest.getFeedbackDate());
        feedback.setRating(feedbackDtoRequest.getRating());
        feedback.setFeedbackCourse(courseService.getCourseById(feedbackDtoRequest.getCourseId()));
        feedback.setFeedbackStudent(studentService.getStudentById(feedbackDtoRequest.getStudentId()));
        return feedback;
    }
}
