package com.sprintbook.dto;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    UUID id;
    String firstName;
    String middleName;
    String lastName;
    String email;
    String phoneNumber;

    Date createdAt;
    Date updatedAt;
}
