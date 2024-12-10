package org.example.dp_project.service;

import org.example.dp_project.dto.FeedbackDto;
import org.example.dp_project.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback getFeedbackById(Long id);
    List<FeedbackDto> getFeedbackByCourseId(Long courseId);
    List<FeedbackDto> getFeedbackByStudentId(Long studentId);
    List<FeedbackDto> getAllFeedbacks();

    FeedbackDto createFeedback(FeedbackDto feedbackDtoRequest);
    FeedbackDto updateFeedback(FeedbackDto feedbackDtoRequest);

    List<FeedbackDto> sortByRating(List<FeedbackDto> feedbackDtoList);
    List<FeedbackDto> sortByFeedbackDate(List<FeedbackDto> feedbackDtoList);
}
