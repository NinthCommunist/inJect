package org.inject.jdbc.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PictureDTO {

    private int id;
    private String name;
    private String artist;
}
