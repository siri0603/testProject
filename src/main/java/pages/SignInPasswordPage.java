package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPasswordPage extends BasePage{

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement submitButton;


    // Initializing the Page Objects:
    public SignInPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public void inputPassword (String text){
        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys(text);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }
}
