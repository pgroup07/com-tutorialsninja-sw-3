package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {
        // 1.2 This method should click on the menu whatever name is passed as parameter.
        clickOnElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']//a[normalize-space()='" + menu + "']"));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // 1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        // 1.3 Verify the text ‘Desktops’

        String actualTxt = "Desktops";
        String expectedTxt = getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']"));
        Assert.assertEquals(expectedTxt, actualTxt);

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");
        // 2.3 Verify the text ‘Laptops & Notebooks’
        String actualTxt1 = "Laptops & Notebooks";
        String expectedTxt1 = getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        Assert.assertEquals(expectedTxt1, actualTxt1);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        // 3.1 Mouse hover on “Components” Tab and click
        mouseHoverAndClick(By.xpath("//a[normalize-space()='Components']"));
        // 3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");
        // 3.3 Verify the text ‘Components’
        String actualTxt1 = "Components";
        String expectedTxt1 = getTextFromElement(By.xpath("//h2[normalize-space()='Components']"));
        Assert.assertEquals(expectedTxt1, actualTxt1);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
