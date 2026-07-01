package com.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String title;
    private String content;
    private String assignee;
    private String password; //
}