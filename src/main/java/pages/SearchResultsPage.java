package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//div[@data-cel-widget='search_result_1']")
    WebElement firstItemInResults;



    // Initializing the Page Objects:
    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
    }

//    to get firstItem price displayed
    public String getItemPrice(){
        String itemPrice = firstItemInResults.findElement(By.cssSelector("span.a-price-symbol")).getText()+firstItemInResults.findElement(By.cssSelector("span.a-price-whole")).getText()+"."+firstItemInResults.findElement(By.cssSelector("span.a-price-fraction")).getText();
        return itemPrice;
    }

    public void clickOnFirstItemLink (){
        firstItemInResults.findElement(By.xpath(".//a[@class='a-link-normal a-text-normal']")).click();
    }
}
