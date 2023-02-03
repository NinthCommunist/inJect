package grpc.steps;

import io.qameta.allure.Step;
import org.inject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class GrpcSteps {

    @Autowired
    private PicturesServiceGrpc.PicturesServiceBlockingStub stub;

    @Step("Отправка запроса GetArtist по картине {picture}")
    public ArtistResponse getArtistByPicture(String picture) {
        return stub.getArtist(PictureRequest.newBuilder()
                .setPictureName(picture)
                .build());
    }

    @Step("Отправка запроса GetPictures по художнику {artist}")
    public Iterator<PictureResponse> getPicturesByArtist(String artist) {
        return stub.getPictures(ArtistRequest.newBuilder().setArtistName(artist).build());
    }
}
