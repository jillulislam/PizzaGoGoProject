package core;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * author: Tanvir Ahmed
 * username: tahmed@freshdirect.com
 * email: tanvirny07@gmail.com
 * date: 5/30/2020
 * time: 2:02 AM
 **/
public class ScreenshotTaker extends TestWatcher {
    public final TakesScreenshot takesScreenshot;

    public ScreenshotTaker(TakesScreenshot takesScreenshot) {
        this.takesScreenshot = takesScreenshot;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e,description);
        failedStepScreenShot();
    }

    @Attachment("Failed Step Screenshot")
    public byte[] failedStepScreenShot(){
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }
}
