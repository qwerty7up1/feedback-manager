package com.project.view;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageView {
    private long id;
    private String text;
    private LocalDateTime publicationTime;
}
