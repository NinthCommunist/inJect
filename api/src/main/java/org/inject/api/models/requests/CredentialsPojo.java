package org.inject.api.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@AllArgsConstructor
public class CredentialsPojo {

    @EqualsAndHashCode.Exclude
    private final String username;
    private final String password;
}
