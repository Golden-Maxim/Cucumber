import core.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static core.MyMethods.checkPrice;
import PageObject.*;

public class HotlineRun {

    @Test
    public  void checkTypeOfProduct(){
        PageObject.navigateTo("https://hotline.ua/");

       // WebElement alert = DriverManager.driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/span[1]"));
        //alert.click();
        MainPage mainPage = new MainPage();
        ItemList itemList = new ItemList();
        PageOfProduct pageOfProduct = new PageOfProduct();

        mainPage.closePopUpWindow();

        DriverManager.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        mainPage.searchItemInTheSearchField();

        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'products-list')]/li[1]/div/p/a")));

        itemList.goToPageOfProduct();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-product\"]/div[3]/div/div[2]/div/div[2]/div")));

        pageOfProduct.checkDescription();

        DriverManager.killDriver();

    }

    @Test
    public void sortPrice()
    {
        PageObject.navigateTo("https://hotline.ua/");

        MainPage mainPage = new MainPage();
        ItemList itemList = new ItemList();
        PageOfProduct pageOfProduct = new PageOfProduct();

        mainPage.closePopUpWindow();

        DriverManager.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        mainPage.searchItemInTheSearchField();

        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class ,'price-md')]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@class,'field')]/option[contains(@value,'1')]")));

        itemList.sortByPrice();


        WebElement nextPage;

        for (int i = 1; i < 5;i++ ){

            nextPage = DriverManager.driver.findElement(By.xpath("//*[@id=\"page-search\"]/div[2]/div/div[2]/div[2]/a["+ i +"]"));
            nextPage.click();
            DriverManager.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement price[] = DriverManager.driver.findElements(By.xpath("//div[span[contains(@class, 'value')]]")).toArray(new WebElement[0]);
            System.out.println("Price from: " + i + " page" );
            checkPrice(price);
        }

        DriverManager.killDriver();

    }
    @Test
    public void goggleSearch(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(PageObject.locator("https://www.google.com/"));
        driver.findElement(By.name("q")).sendKeys("Максім Стовбчатий" + Keys.ENTER);




    }

}



