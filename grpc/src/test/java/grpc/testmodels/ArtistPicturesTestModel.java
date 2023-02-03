package grpc.testmodels;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class ArtistPicturesTestModel {

    private String artist;
    private List<String> pictures;
}
