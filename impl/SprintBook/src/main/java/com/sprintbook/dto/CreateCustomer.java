package com.sprintbook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomer {
    String firstName;
    String middleName;
    String lastName;
    String email;
    String phoneNumber;
}
