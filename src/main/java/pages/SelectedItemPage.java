package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedItemPage extends BasePage{

    @FindBy(xpath = "//span[@id='newBuyBoxPrice']")
    WebElement priceBoxElement;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCartButton;


    // Initializing the Page Objects:
    public SelectedItemPage() {
        PageFactory.initElements(driver, this);
    }

    //    to get price displayed
    public String getItemPriceFromItemPage(){
        String itemPrice = priceBoxElement.getText();
        return itemPrice;
    }

    public void clickOnAddToCart(){
        addToCartButton.click();
    }

}
