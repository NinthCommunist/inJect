package org.inject.api.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CredentialsPojo {

    private final String username;
    private final String password;
}
