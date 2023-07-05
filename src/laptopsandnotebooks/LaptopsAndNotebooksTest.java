package laptopsandnotebooks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        // 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // 1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        // 1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        // 1.4 Verify the Product price will arrange in High to Low order.
//        String actualText = "";
//        String expectedText = getTextFromElement(By.xpath(""));
//        Assert.assertEquals(expectedText, actualText);


        // before filter capture the price
        List<WebElement> BeforeFilterPrice = driver.findElements(By.className("price"));
        // remove the symbol $ from the price and convert the string into double
        List<Double> BeforeFilterPriceList = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement p : BeforeFilterPrice) {
            String[] arry = p.getText().split("$");

            BeforeFilterPriceList.add(Double.valueOf(arry[1]));
            System.out.println(BeforeFilterPriceList);
        }
//        Select dropdown =new Select(driver.findElement(By.className("form-control")));
//       selectByVisibleTextFromDropDown(B);


        // filter the price from the dropdown
        selectByVisibleTextFromDropDown(By.className("form-control"), "Price (High > Low)");
        // after filter capture the price
        List<WebElement> afterFilterPrice = driver.findElements(By.className("price"));
        // remove the symbol $ from the price and convert the string into double
        List<Double> afterFilterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Collections.sort(BeforeFilterPriceList); // It will sort the value

        Assert.assertEquals(BeforeFilterPriceList, afterFilterPrice);
        Thread.sleep(1000);

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // 2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        // 2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        // 2.4 Select Product “MacBook”
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//a[text()='MacBook']"), "MacBook");
        // 2.5 Verify the text “MacBook”
        String actualText = "MacBook";
        String expectedText = getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"));
        Assert.assertEquals(expectedText, actualText);
        // 2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualText1 = "Success: You have added MacBook to your shopping cart!";
        String expectedText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expectedText1, actualText1);
        // 2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // 2.9 Verify the text "Shopping Cart"
        String actualText2 = "shopping cart";
        String expectedText2 = getTextFromElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Assert.assertEquals(expectedText2, actualText2);
        // 2.10 Verify the Product name "MacBook"
        String actualText3 = "MacBook";
        String expectedText3 = getTextFromElement(By.xpath("(//a[contains(text(),'MacBook')])[2]"));
        Assert.assertEquals(expectedText3, actualText3);
        // 2.11 Change Quantity "2"
        driver.findElement(By.xpath("//input[@name='quantity")).clear();
        selectByVisibleTextFromDropDown(By.xpath("//input[@name='quantity"), "2");
        // 2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));
        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualText4 = "Success: You have modified your shopping cart!";
        String expectedText4 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expectedText4, actualText4);
        // 2.14 Verify the Total $1,204.00
        String actualText5 = "$1,204.00";
        String expectedText5 = getTextFromElement(By.xpath("(//td[@class='text-right'][normalize-space()='$1,204.00'])[3]"));
        Assert.assertEquals(expectedText5, actualText5);
        // 2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        // 2.16 Verify the text “Checkout”
        String actualText6 = "Checkout";
        String expectedText6 = getTextFromElement(By.xpath("//a[@class='btn btn-primary']"));
        Assert.assertEquals(expectedText6, actualText6);
        // 2.17 Verify the Text “New Customer”
        String actualText7 = "New Customer";
        String expectedText7 = getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']"));
        Assert.assertEquals(expectedText7, actualText7);
        // 2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        // 2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        // 2.20 Fill the mandatory fields
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='input-payment-firstname']"), "Arjun");
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='input-payment-lastname']"), "Pandit");
        selectByVisibleTextFromDropDown(By.xpath("Pandit1@gmail.com"), "Pandit123@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='input-payment-telephone']"), "98766543210");
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='input-payment-address-1']"), "Street");
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='input-payment-city']"), "London");
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='input-payment-postcode']"), "HA5 8FD");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-country']"), "Albania");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Berat");
        // 2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        // 2.22 Add Comments About your order into text area
        selectByVisibleTextFromDropDown(By.xpath("//textarea[@name='comment']"), "Hello...");
        // 2.23 Check the Terms & Conditions check box
        selectCheckBox(By.xpath("//input[@name='agree']"));
        // 2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        // 2.25 Verify the message “Warning: Payment method required!”
        String actualText8 = "Warning: Payment method required!";
        String expectedText8 = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals(expectedText8, actualText8);


    }

}
