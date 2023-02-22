package org.inject.web.testhelpers.screenshots;

import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.inject.web.seleniumhelper.WebDriverHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

@Component
@Scope(value = "threadlocal", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ScreenshotMaker {

    private final WebDriverHolder driver;

    @Autowired
    public ScreenshotMaker(WebDriverHolder driver) {
        this.driver = driver;
    }

    @Attachment(value = "screenshot", type = "image/png")
    @SneakyThrows
    public byte[] makeScreenshot() {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver.getDriver());
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ImageIO.write(screenshot.getImage(), "png", buffer);
        return buffer.toByteArray();
    }
}
