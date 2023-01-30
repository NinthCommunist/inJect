package grpc.dataprovider;

import net.datafaker.Faker;
import org.inject.storage.ArtistStorage;

import java.util.*;
import java.util.stream.Collectors;

import org.testng.annotations.DataProvider;

public class TestData {

    ArtistStorage storage = new ArtistStorage();
    Faker faker = new Faker();


    @DataProvider(name = "getPictures")
    public Iterator<Object[]> forGetPictures(){
        Map<String, List<String>> artistPictures = storage.getArtistPictures();
        return artistPictures.entrySet()
                .stream()
                .map(entry->new Object[]{entry.getKey(), entry.getValue()})
                .collect(Collectors.toList()).iterator();
    }

    @DataProvider(name = "getArtist")
    public Iterator<Object[]> forGetArtist(){
        Map<String, List<String>> artistPictures = storage.getArtistPictures();
        return artistPictures.entrySet()
                .stream()
                .map(entry->new Object[]{
                        entry.getKey(),
                        faker.options().nextElement(entry.getValue()),
                        entry.getValue()})
                .collect(Collectors.toList()).iterator();
    }
}
