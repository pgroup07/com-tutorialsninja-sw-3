package myaccounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.UUID;

public class MyAccountsTest extends Utility {
    // 1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option) {
        // 1.2 This method should click on the options whatever name is passed as parameter.
        clickOnElement(By.xpath("//span[@class='caret']"));
        clickOnElement(By.xpath("//a[normalize-space()='" + option + "']"));
    }

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    String email;


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // 1.1 Click on My Account Link.
        // 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        // 1.3 Verify the text “Register Account”.
        String actualText = "Register Account";
        String expectedText = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        String uuid = UUID.randomUUID().toString();
        email = "admin" + uuid + "@gmail.com";
        // 3.1 Click  on My Account Link.
        // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        // 3.3 Enter First Name
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Admin");
        // 3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "123");
        // 3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), email);
        // 3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "9876543210");

        // 3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Admin@123");

        // 3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Admin@123");

        // 3.9 Select Subscribe Yes radio button
        selectCheckBox(By.xpath("//label[normalize-space()='Yes']"));
        // 3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        // 3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        Thread.sleep(1000);
        // 3.12 Verify the message “Your Account Has Been Created!”
        String actualText = "Your Account Has Been Created!";
        String expectedText = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        Assert.assertEquals(expectedText, actualText);
        // 3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // 3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[@class='caret']"));

        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        Thread.sleep(1000);
        // 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        // 3.16 Verify the text “Account Logout”
        String actualText1 = "Account Logout";
        String expectedText1 = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals(expectedText1, actualText1);
        // 3.17 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        String uuid = UUID.randomUUID().toString();
        email = "admin" + uuid + "@gmail.com";
        // 4.1 Click on My Account Link.

        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        clickOnElement(By.xpath("//span[@class='caret']"));
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), email);
        //4.4 Enter Last Name
        //sendTextToElement(By.xpath(""), "");
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Admin@123");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        String actualText = "My Account";
        String expectedText = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        Assert.assertEquals(expectedText, actualText);

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//span[@class='caret']"));
        selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        String actualText1 = "Account Logout";
        String expectedText1 = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals(expectedText1, actualText1);
        // 4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }
}
