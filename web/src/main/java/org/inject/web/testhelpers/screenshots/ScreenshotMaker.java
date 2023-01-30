package org.inject.web.testhelpers.screenshots;

import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

@Component
@Scope("threadlocal")
public class ScreenshotMaker {

    @Autowired
    private WebDriver driver;

    @Attachment(value = "screenshot", type = "image/png")
    @SneakyThrows
    public byte[] makeScreenshot() {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ImageIO.write(screenshot.getImage(), "png", buffer);
        return buffer.toByteArray();
    }
}
