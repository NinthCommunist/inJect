package org.inject.jdbc.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Component
@Data
public class PictureDTO {

    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String artist;
}
