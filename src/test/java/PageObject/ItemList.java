package PageObject;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemList {

    private By firstProductOflist = By.xpath("//ul[contains(@class, 'products-list')]/li[1]/div/p/a");
    private By filter = By.xpath("//div[contains(@class,'sorting')]//select");
    private By sortPrice = By.xpath("//select[contains(@class,'field')]/option[contains(@value,'1')]");


    private PageOfProduct goToPageOfProduct(){
        WebElement product = DriverManager.getDriver().findElement(firstProductOflist);
        product.click();
        return new PageOfProduct();
    }
    public ItemList sortByPrice(){
        WebElement f = DriverManager.getDriver().findElement(filter);
        WebElement sbyPrice = DriverManager.getDriver().findElement(sortPrice);
        f.click();
        sbyPrice.click();
        return new ItemList();
    }

}
