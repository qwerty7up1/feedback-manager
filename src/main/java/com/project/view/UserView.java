package com.project.view;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserView {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<MessageView> messages;
}
