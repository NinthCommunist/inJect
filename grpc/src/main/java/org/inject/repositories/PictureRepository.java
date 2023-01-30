package org.inject.repositories;

import org.inject.storage.ArtistStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PictureRepository {

    @Autowired
    private ArtistStorage artistStorage;

    public List<String> getPicturesByArtist(String artist) {
        switch (artist) {
            case "Перов":
                return artistStorage.getPerovPictures();
            case "Шишкин":
                return artistStorage.getShishkinPictures();
            case "Айвазовский":
                return artistStorage.getAivazovskyPictures();
            case "Брюлов":
                return artistStorage.getBrulovPictures();
            case "Репин":
                return artistStorage.getRepinPictures();
            case "Васнецов":
                return artistStorage.getVasnetsovPictures();
            case "Суриков":
                return artistStorage.getSurikovPictures();
            default:
                throw new IllegalArgumentException("В storage не нашлось такого художника");
        }
    }

    public String getArtistByPicture(String picture){
        List<String> artists = artistStorage.getArtistPictures().entrySet().stream()
                .filter(entry->entry.getValue().contains(picture))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if(artists.size()!=1){
            throw new IllegalArgumentException("По данной картине нашелся не один художник");
        }
        return artists.get(0);
    }
}
