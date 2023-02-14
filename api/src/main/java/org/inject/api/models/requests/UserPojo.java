package org.inject.api.models.requests;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class UserPojo {

    @EqualsAndHashCode.Exclude
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
