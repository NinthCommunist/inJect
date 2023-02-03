/*
package grpc.tests;

import com.google.common.collect.ImmutableList;
import grpc.TestConfig;
import grpc.dataprovider.TestData;
import grpc.steps.GrpcSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.inject.ArtistResponse;
import org.inject.PictureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration(classes = TestConfig.class)
@Epic("Тест сервиса GRPC")
public class PictureServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired(required = true)
    private GrpcSteps grpcSteps;

    @Test(dataProviderClass = TestData.class, dataProvider = "getPictures")
    @Story("Тестирование GetPictures")
    public void getPicturesTest(String artist, List<String> pictures) {
        List<PictureResponse> responses = ImmutableList.copyOf(grpcSteps.getPicturesByArtist(artist));

        //Один элемент PictureResponse содержит только одну картину
        responses.forEach(response->Assert.assertTrue(pictures.contains(response.getPictureName())));
        Assert.assertEquals(pictures.size(), responses.size());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "getArtist")
    @Story("Тестирование GetArtist")
    public void getArtistTest(String expectedArtist, String pictureForSearch, List<String> expectedPictures) {
        ArtistResponse response = grpcSteps.getArtistByPicture(pictureForSearch);

        Assert.assertEquals(response.getArtistName(), expectedArtist);
        Assert.assertEquals(response.getPicturesList(), expectedPictures);
    }

}
*/
