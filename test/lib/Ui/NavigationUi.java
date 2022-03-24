package lib.Ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUi extends MainPageObject{

    public NavigationUi(AppiumDriver driver)
    {
        super(driver);
    }

    private static final String
            NAVIGATION_BACK_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            VIDGET_IMAGEBUTTON = "//android.widget.ImageButton",
            LABEL_SAVE = "//*[@resource-id='org.wikipedia:id/navigation_bar_item_small_label_view'][@text='Saved']";

    public void clickSave()
    {
       this.waitForElementAndClick(
                By.xpath(NAVIGATION_BACK_BUTTON),
                "Cannot find button 'Navigate back'",
                15
        );

        this.waitForElementAndClick(
                By.xpath(VIDGET_IMAGEBUTTON),
                "Cannot find widget ImageButton'",
                15
        );

        this.waitForElementAndClick(
                By.xpath(LABEL_SAVE),
                "Cannot find label Saved",
                15
        );
    }
}
