package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // 1.1 Mouse hover on Desktops Tab.and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        sendTextToElement(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        String actualMsg = "Name (Z - A)";
        String expectMsg = getTextFromElement(By.xpath("//option[text()='Name (Z - A)']"));
        Assert.assertEquals(expectMsg, actualMsg);


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 Mouse hover on Desktops Tab. and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        sendTextToElement(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //2.4 Select product “HP LP3065”
        sendTextToElement(By.xpath("//a[normalize-space()='HP LP3065']"), "HP LP3065");
        //2.5 Verify the Text "HP LP3065"
        Thread.sleep(1000);
        String actualText = "HP LP3065";
        String expectedText = getTextFromElement(By.xpath("(//a[normalize-space()='HP LP3065'])[1]"));
        Assert.assertEquals(expectedText, actualText);

        //clickOnElement(By.xpath("(//button[contains(@type,'button')])[9]"));
        //2.6 Select Delivery Date "2022-11-30"
        //  sendTextToElement(By.xpath(""), "");

        //2.7.Enter Qty "1” using Select class.
        sendTextToElement(By.xpath("(//button[contains(@type,'button')])[9]"), "1");
        //2.8 Click on “Add to Cart” button
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//button[normalize-space()='Add to Cart'])[1]"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(2000);
        String actualText1 = "Success: You have added HP LP3065 to your shopping cart!";
        String expectedText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expectedText1, actualText1);
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.11 Verify the text "Shopping Cart"
        String actualText2 = "Shopping Cart         (1.00kg) ";
        String expectedText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals(expectedText2, actualText2);
        //2.12 Verify the Product name "HP LP3065"
        String actualText3 = "HP LP3065";
        String expectedText3 = getTextFromElement(By.xpath("(//a[contains(text(),'HP LP3065')])[2]"));
        Assert.assertEquals(expectedText3, actualText3);
        //2.13 Verify the Delivery Date:2011-04-22"
        String actualText4 = "Delivery Date:2011-04-22";
        String expectedText4 = getTextFromElement(By.xpath("(//small[normalize-space()='Delivery Date:2011-04-22'])[1]"));
        Assert.assertEquals(expectedText4, actualText4);
        //2.14 Verify the Model "Product21"
        String actualText5 = "Product 21";
        String expectedText5 = getTextFromElement(By.xpath("//td[normalize-space()='Product 21']"));
        Assert.assertEquals(expectedText5, actualText5);
        //2.15 Verify the Total "$122.00"
        String actualText6 = "$122.00";
        String expectedText6 = getTextFromElement(By.xpath("(//td[contains(text(),'$122.00')])[4]"));
        Assert.assertEquals(expectedText6, actualText6);
    }

    @After
    public void tearDown() {
        // closeBrowser();
    }
}
