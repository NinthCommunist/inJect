package org.inject.api.models.requests;

import lombok.Data;

@Data
public class UserPojo {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
