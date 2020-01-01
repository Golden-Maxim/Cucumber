package PageObject;


import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
    public By closeUp = By.xpath("/html/body/header/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/span[1]");
    public By searchField  = By.xpath("//*[@id=\"searchbox\"]");
    public By searchButton = By.xpath("//*[@id=\"doSearch\"]");

    public MainPage closePopUpWindow(){
        WebElement close = DriverManager.getDriver().findElement(closeUp);
        close.click();

        return new MainPage();
    }

    public ItemList searchItemInTheSearchField(){
        WebElement searchInput = DriverManager.getDriver().findElement(searchField);
        searchInput.click();
        searchInput.sendKeys("телевизор");
        WebElement searchButtonMainPage = DriverManager.getDriver().findElement(searchButton);
        searchButtonMainPage.click();
        return new ItemList();
    }

}


