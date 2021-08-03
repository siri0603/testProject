package web;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ItemPriceTest extends BasePage {



    @BeforeMethod
    public void setup(){
        loadConfigs();
        browser_Initialization();
    }

    @Test
    public void verifyItemPrice(){

        launch_url();
        HomePage homePage = new HomePage();
        homePage.inputSearchText(searchString);
        homePage.clickOnSearchButton();


        SearchResultsPage searchResultsPage = new SearchResultsPage();
        //To assert displayed price matches with expected
        Assert.assertEquals(searchResultsPage.getItemPrice(), expectedItemPrice, "Price did not match at search results page.");
        searchResultsPage.clickOnFirstItemLink();

        SelectedItemPage selectedItemPage = new SelectedItemPage();
        Assert.assertEquals(selectedItemPage.getItemPriceFromItemPage(), expectedItemPrice, "Price did not match at Item page.");
        selectedItemPage.clickOnAddToCart();


        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertEquals(shoppingCartPage.getItemPriceFromCartPage(), expectedItemPrice, "Price did not match at Shopping Cart page.");
        shoppingCartPage.clickOnProceedToCheckoutButton();

        SignInUsernamePage signInUsernamePage = new SignInUsernamePage();
        signInUsernamePage.inputEmailId(username);
        signInUsernamePage.clickOnContinueButton();

        SignInPasswordPage signInPasswordPage = new SignInPasswordPage();
        signInPasswordPage.inputPassword(password);
        signInPasswordPage.clickOnSubmitButton();

        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertEquals(checkoutPage.getItemPriceFromCheckoutPage(), expectedItemPrice, "Price did not match at Checkout page.");

    }

    @AfterMethod
    public void quitBrowser(){
    closeBrowser();
    }
}
