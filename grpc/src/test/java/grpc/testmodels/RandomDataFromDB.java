package grpc.testmodels;

import grpc.testmodels.ArtistPicturesTestModel;
import net.datafaker.Faker;
import org.inject.jdbc.models.ArtistDTO;
import org.inject.jdbc.models.PictureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RandomDataFromDB {

    private final JdbcTemplate jdbcTemplate;
    private  final Faker faker;

    @Autowired
    public RandomDataFromDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.faker = new Faker();
    }

    public ArtistPicturesTestModel getArtistPictures(){
        String artist=faker.options().nextElement(getAllArtist());
        return ArtistPicturesTestModel.builder()
                .artist(artist)
                .pictures(getPicturesByArtist(artist))
                .build();
    }

    private final String ALL_ARTIST = "SELECT * FROM artist";
    private List<String> getAllArtist(){
        return jdbcTemplate.query(ALL_ARTIST, new BeanPropertyRowMapper<>(ArtistDTO.class))
                .stream().map(artistDTO -> artistDTO.getFirstName() + " " + artistDTO.getLastName())
                .collect(Collectors.toList());
    }

    private final String PICTURES_BY_ARTIST = "SELECT p.name, CONCAT_WS(' ', a.first_name, a.last_name) artist " +
            "FROM pictures p JOIN artist a ON p.artist_id = a.id " +
            "WHERE CONCAT_WS(' ', a.first_name, a.last_name) = ?";
    private List<String> getPicturesByArtist(String artist){
        return jdbcTemplate.query(PICTURES_BY_ARTIST, new BeanPropertyRowMapper<>(PictureDTO.class), artist)
                .stream()
                .map(PictureDTO::getName).collect(Collectors.toList());
    }


}