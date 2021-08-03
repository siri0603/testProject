package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInUsernamePage extends BasePage{

    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continmueButton;


    // Initializing the Page Objects:
    public SignInUsernamePage() {
        PageFactory.initElements(driver, this);
    }

    public void inputEmailId (String text){
        usernameTextBox.click();
        usernameTextBox.clear();
        usernameTextBox.sendKeys(text);
    }

    public void clickOnContinueButton(){
        continmueButton.click();
    }
}
