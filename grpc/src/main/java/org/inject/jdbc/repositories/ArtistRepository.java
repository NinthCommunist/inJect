package org.inject.jdbc.repositories;

import org.inject.jdbc.models.ArtistDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class ArtistRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(ArtistRepository.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArtistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String ARTIST_BY_PICTURE = "SELECT a.first_name firstName, a.last_name lastName FROM artist a " +
            "JOIN pictures p ON a.id = p.artist_id " +
            "WHERE p.name = ?";
    public String getArtistByPicture(String pictureName) {
        LOGGER.info("Поиск художника по картине " + pictureName);
        ArtistDTO artistDTO =  jdbcTemplate.queryForObject(ARTIST_BY_PICTURE, new BeanPropertyRowMapper<>(ArtistDTO.class), pictureName);
        return Objects.requireNonNull(artistDTO).getFirstName()+" "+artistDTO.getLastName();
    }


}
