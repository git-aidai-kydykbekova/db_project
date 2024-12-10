package org.example.dp_project.service;

import org.example.database_project.dto.FeedbackDto;
import org.example.database_project.dto.FeedbackDtoRequest;
import org.example.database_project.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback getFeedbackById(Long id);
    List<FeedbackDto> getFeedbackByCourseId(Long courseId);
    List<FeedbackDto> getFeedbackByStudentId(Long studentId);
    List<FeedbackDto> getAllFeedbacks();

    FeedbackDto createFeedback(FeedbackDtoRequest feedbackDtoRequest);
    FeedbackDto updateFeedback(FeedbackDtoRequest feedbackDtoRequest);

    List<FeedbackDto> sortByRating(List<FeedbackDto> feedbackDtoList);
    List<FeedbackDto> sortByFeedbackDate(List<FeedbackDto> feedbackDtoList);
}
