
package org.inject.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.inject.*;
import org.inject.jdbc.models.PictureDTO;
import org.inject.jdbc.repositories.ArtistRepository;
import org.inject.jdbc.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class PictureService extends PicturesServiceGrpc.PicturesServiceImplBase {


    private final PictureRepository pictureRepository;
    private final ArtistRepository artistRepository;

    @Autowired
    public PictureService(PictureRepository repository, ArtistRepository artistRepository) {
        this.pictureRepository = repository;
        this.artistRepository = artistRepository;
    }

    @Override
    public void getPictures(ArtistRequest request, StreamObserver<PictureResponse> responseObserver) {
        String artist = request.getArtistName();
        List<PictureDTO> pictures = pictureRepository.getPicturesByArtist(artist);

        pictures.forEach(picture ->
                responseObserver.onNext(
                        PictureResponse.newBuilder()
                                .setArtistName(picture.getArtist())
                                .setPictureName(picture.getName())
                                .build()));

        responseObserver.onCompleted();
    }


    @Override
    public void getArtist(PictureRequest request, StreamObserver<ArtistResponse> responseObserver) {
        String pictureRequest = request.getPictureName();
        String artist = artistRepository.getArtistByPicture(pictureRequest);

        List<String> picturesNames = pictureRepository.getPicturesByArtist(artist).
                stream().map(PictureDTO::getName).collect(Collectors.toList());

        responseObserver.onNext(
                ArtistResponse.newBuilder()
                        .setArtistName(artist)
                        .addAllPictures(picturesNames)
                        .build());
        responseObserver.onCompleted();
    }
}

