package core;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.events.StepFinishedEvent;
import ru.yandex.qatools.allure.events.StepStartedEvent;
import ru.yandex.qatools.allure.experimental.LifecycleListener;

import java.util.Deque;
import java.util.LinkedList;

/**
 * author: Tanvir Ahmed
 * username: tahmed@freshdirect.com
 * email: tanvirny07@gmail.com
 * date: 5/30/2020
 * time: 2:09 AM
 **/
public class AllureReportConfig extends LifecycleListener {
    public static WebDriver driver;
    private Deque<String> names = new LinkedList<>();
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void fire(StepStartedEvent event) {
        names.push(event.getName());
        logger.info(getOffset() + "@Step:" + names.getFirst());
    }

    @Override
    public void fire(StepFinishedEvent event) {
        logger.info(getOffset() + "@Step done " + names.poll());
    }

    private String getOffset() {
        return new String(new char[names.size() == 0 ? 0 : names.size() - 1]).replaceAll("\0", "   ");
    }

    @Rule
    public TestWatcher screenshotTaker = new ScreenshotTaker((TakesScreenshot) driver);
}
