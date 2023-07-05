package utilities;

import browsertesting.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on Element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //*********************** Alert Method *******************//
    // Switch,accept,dismiss,gettextfromalert,sendtexttoalert  -- 5 Method write


    //**********************Select Class Methods *****************//

    /**
     * This method will select the option by visible Text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);

    }

    /**
     * This method will select the option by visible Value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);


    }

    /**
     * This method use to get page Title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * This method will select the option from checkbox
     */
    public void selectCheckBox(By by) {

        if (driver.findElement(by).isSelected()) {

        } else
            driver.findElement(by).click();
    }

    /**
     * This method is use for Mouse Hover
     */
    public void mouseHover(By by) {
        //WebElement mouse=driver.findElement(by);
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(by)).build().perform();
    }


    public void mouseHoverAndClick(By by) {
        //WebElement mouse=driver.findElement(by);
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(by)).click().build().perform();
    }

    public void dateTimePicker(By by) {
        clickOnElement(by); // Opens the date picker
        while (true) {
            String monthYear = driver.findElement(by).getText();
            // Nov 2022
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(mon) && yer.equalsIgnoreCase(yer)) {
                break;
            } else {
                clickOnElement(by);
            }
        }
    }

    public void verifyAssert(By By) {

     // Assert.assertEquals(String expectedText = getTextFromElement(By),  String actualText = "");
    }

}
