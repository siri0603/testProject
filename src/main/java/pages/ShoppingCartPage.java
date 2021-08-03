package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage{

    @FindBy(xpath = "//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
    WebElement priceBoxElement;

    @FindBy(xpath = "//a[@id='hlb-ptc-btn-native']")
    WebElement proceedCheckoutButton;


    // Initializing the Page Objects:
    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    //    to get price displayed
    public String getItemPriceFromCartPage(){
        String itemPrice = priceBoxElement.getText();
        return itemPrice;
    }

    public void clickOnProceedToCheckoutButton(){
        proceedCheckoutButton.click();
    }

}
