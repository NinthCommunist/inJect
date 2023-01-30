package grpc.steps;

import org.inject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class GrpcSteps {

    @Autowired
    private PicturesServiceGrpc.PicturesServiceBlockingStub stub;

    public ArtistResponse getArtistByPicture(String picture) {
        return stub.getArtist(PictureRequest.newBuilder()
                .setPictureName(picture)
                .build());
    }

    public Iterator<PictureResponse> getPicturesByArtist(String artist) {
        return stub.getPictures(ArtistRequest.newBuilder().setArtistName(artist).build());
    }
}
