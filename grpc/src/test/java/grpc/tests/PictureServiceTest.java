package grpc.tests;

import com.google.common.collect.ImmutableList;
import grpc.TestConfig;
import grpc.dataprovider.TestData;
import grpc.steps.GrpcSteps;
import grpc.testmodels.ArtistPicturesTestModel;
import grpc.testmodels.RandomDataFromDB;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.inject.ArtistResponse;
import org.inject.PictureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration(classes = {TestConfig.class})
@Epic("Тест сервиса GRPC")
public class PictureServiceTest extends AbstractTestNGSpringContextTests {


    @Autowired
    private GrpcSteps grpcSteps;

    @Autowired
    private RandomDataFromDB randomDataFromDB;

    @Test(description = "GetPictures по фиксированным данным",
            dataProviderClass = TestData.class, dataProvider = "getPictures")
    @Story("Тестирование GetPictures")
    public void getPicturesTest(String artist, List<String> pictures) {
        List<PictureResponse> responses = ImmutableList.copyOf(grpcSteps.getPicturesByArtist(artist));

        //Один элемент PictureResponse содержит только одну картину
        responses.forEach(response -> Assert.assertTrue(pictures.contains(response.getPictureName())));
        Assert.assertEquals(pictures.size(), responses.size());
    }

    @Test(description = "GetArtist по фиксированным данным",
            dataProviderClass = TestData.class, dataProvider = "getArtist")
    @Story("Тестирование GetArtist")
    public void getArtistTest(String expectedArtist, String pictureForSearch, List<String> expectedPictures) {
        ArtistResponse response = grpcSteps.getArtistByPicture(pictureForSearch);

        Assert.assertEquals(response.getArtistName(), expectedArtist);
        Assertions.assertThat(response.getPicturesList())
                .containsExactlyInAnyOrderElementsOf(expectedPictures);
    }

    @Test(description = "случайные данные из БД")
    @Story("Тестирование GetPictures")
    public void getRandomPicturesTest() {
        ArtistPicturesTestModel artistPictures = randomDataFromDB.getArtistPictures();
        List<PictureResponse> responses = ImmutableList.copyOf(grpcSteps.getPicturesByArtist(artistPictures.getArtist()));

        //Один элемент PictureResponse содержит только одну картину
        responses.forEach(response -> Assert.assertTrue(artistPictures.getPictures()
                .contains(response.getPictureName())));
        Assert.assertEquals(artistPictures.getPictures().size(), responses.size());
    }

    @Test(description = "случайные данные из БД")
    @Story("Тестирование GetArtist")
    public void getRandomArtistTest() {
        ArtistPicturesTestModel artistPictures = randomDataFromDB.getArtistPictures();
        artistPictures.getPictures().forEach(
                picture -> {
                    ArtistResponse response = grpcSteps.getArtistByPicture(picture);

                    Assert.assertEquals(response.getArtistName(), artistPictures.getArtist());
                    Assert.assertEquals(response.getPicturesList(), artistPictures.getPictures());
                }
        );


    }

}
