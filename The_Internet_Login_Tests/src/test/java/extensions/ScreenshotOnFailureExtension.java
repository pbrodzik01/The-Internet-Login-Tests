package extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import utils.ScreenshotUtils;
import utils.WebDriverProvider;

public class ScreenshotOnFailureExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        Object testInstance = context.getRequiredTestInstance();

        if (testInstance instanceof WebDriverProvider driverProvider) {
            ScreenshotUtils.saveScreenshot(
                    driverProvider.getDriver(),
                    context.getRequiredTestMethod().getName()
            );
        }

        throw throwable;
    }
}