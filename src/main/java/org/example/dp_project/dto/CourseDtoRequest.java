package org.example.dp_project.dto;

public class CourseDtoRequest {
    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private Integer price;
    private Long instructorId;
    private Long categoryId;

    public CourseDtoRequest() {}

    public Long getId() {
        return id;
    }

    public CourseDtoRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CourseDtoRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CourseDtoRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public CourseDtoRequest setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public CourseDtoRequest setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public CourseDtoRequest setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public CourseDtoRequest setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
