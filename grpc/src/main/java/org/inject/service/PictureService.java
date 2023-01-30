package org.inject.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.inject.*;
import org.inject.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

@GrpcService
public class PictureService extends PicturesServiceGrpc.PicturesServiceImplBase {

    @Autowired
    private PictureRepository repository;

    @Override
    public void getPictures(ArtistRequest request, StreamObserver<PictureResponse> responseObserver) {
        String artist = request.getArtistName();
        List<String> pictures = repository.getPicturesByArtist(artist);

        pictures.forEach(picture ->
                responseObserver.onNext(
                        PictureResponse.newBuilder()
                                .setArtistName(artist)
                                .setPictureName(picture)
                                .build()));

        responseObserver.onCompleted();
    }

    @Override
    public void getArtist(PictureRequest request, StreamObserver<ArtistResponse> responseObserver) {
        String pictureRequest = request.getPictureName();
        String artist = repository.getArtistByPicture(pictureRequest);

        List<String> pictures = repository.getPicturesByArtist(artist);

        responseObserver.onNext(
                ArtistResponse.newBuilder()
                        .setArtistName(artist)
                        .addAllPictures(pictures)
                        .build());
        responseObserver.onCompleted();
    }
}
