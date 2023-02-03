package org.inject.jdbc.models;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
public class PictureDTO {

    private int id;
    private String name;
    private String artist;
}
