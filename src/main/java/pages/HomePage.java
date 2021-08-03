package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchSubmitButton;


    // Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void inputSearchText (String text){
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public void clickOnSearchButton(){
        searchSubmitButton.click();
    }
}
