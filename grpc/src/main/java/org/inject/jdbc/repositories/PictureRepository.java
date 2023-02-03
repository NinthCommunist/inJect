
package org.inject.jdbc.repositories;

import org.inject.jdbc.models.PictureDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public class PictureRepository {
    private final String PICTURES_BY_ARTIST = "SELECT p.name, CONCAT_WS(' ', a.first_name, a.last_name) artist " +
            "FROM pictures p JOIN artist a " +
            "ON p.artist_id = a.id " +
            "WHERE CONCAT_WS(' ', a.first_name, a.last_name) = ?";

    private final JdbcTemplate jdbcTemplate;

    private static Logger LOGGER = LoggerFactory.getLogger(PictureRepository.class);

    @Autowired
    public PictureRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PictureDTO> getPicturesByArtist(String artist) {
        LOGGER.info("Поиск картин художника " + artist);
        return jdbcTemplate.query(PICTURES_BY_ARTIST, new BeanPropertyRowMapper<>(PictureDTO.class), artist);
    }
}
