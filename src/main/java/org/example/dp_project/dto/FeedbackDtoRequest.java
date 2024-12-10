package org.example.dp_project.dto;

import java.sql.Timestamp;

public class FeedbackDtoRequest {
    private Long id;
    private Double rating;
    private String comment;
    private Timestamp feedbackDate;
    private Long studentId;
    private Long courseId;

    public FeedbackDtoRequest() {}

    public Long getId() {
        return id;
    }

    public FeedbackDtoRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public FeedbackDtoRequest setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public FeedbackDtoRequest setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Timestamp getFeedbackDate() {
        return feedbackDate;
    }

    public FeedbackDtoRequest setFeedbackDate(Timestamp feedbackDate) {
        this.feedbackDate = feedbackDate;
        return this;
    }

    public Long getStudentId() {
        return studentId;
    }

    public FeedbackDtoRequest setStudentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public Long getCourseId() {
        return courseId;
    }

    public FeedbackDtoRequest setCourseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }
}
