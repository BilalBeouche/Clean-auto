package com.clean.auto.backend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDto {

    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;

}
