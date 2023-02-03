package org.inject.jdbc.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArtistDTO {

    private int id;
    private String firstName;
    private String lastName;
}
