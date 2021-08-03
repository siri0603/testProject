package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//table[@id='subtotals-marketplace-table']")
    WebElement cartTable;


//    Initializing the Page Objects:
    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

//  to get price displayed
    public String getItemPriceFromCheckoutPage(){
        String itemPrice = null;
//  get all the TR elements from the table
        List<WebElement> allRows = cartTable.findElements(By.tagName("tr"));

        Boolean inItemRow = false;

// And iterate over them, getting the item price
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell : cells) {
                if (inItemRow){
                    itemPrice = cell.getText();
                    inItemRow = false;
                    break;
                }

                if(cell.getText().equals("Items:")) {
                    inItemRow = true;
                }

            }
        }
        return itemPrice;
    }

}
