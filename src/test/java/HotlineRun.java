import core.DriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static core.MyMethods.checkPrice;
import PageObject.MainPage;

public class HotlineRun {

    @Test
    public  void checkTypeOfProduct(){
        PageObject.navigateTo("https://hotline.ua/");

       // WebElement alert = DriverManager.driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/span[1]"));
        //alert.click();
        MainPage mainPage = new MainPage();
        mainPage.closePopUpWindow();

        DriverManager.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

       // WebElement input = DriverManager.driver.findElement(By.xpath("//*[@id=\"searchbox\"]"));
        //input.click();
        //input.sendKeys("телевизор");

        //WebElement searchButton = DriverManager.driver.findElement(By.xpath("//*[@id=\"doSearch\"]"));
        //searchButton.click();
        //PageObject.Button("//*[@id=\"doSearch\"]");
        mainPage.EnterTextToSearchField();

        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'products-list')]/li[1]/div/p/a")));

        WebElement list = DriverManager.driver.findElement(By.xpath("//ul[contains(@class, 'products-list')]/li[1]/div/p/a"));
        list.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-product\"]/div[3]/div/div[2]/div/div[2]/div")));

        WebElement listofparameters = DriverManager.driver.findElement(By.xpath("//ul[contains(@class,'breadcrumbs')]"));
        String str = listofparameters.getText();
        String temp[] = str.trim().split("\\s+");
        for (int i = 0;i < temp.length;i++){
            if(temp[i].contains("Телевизоры")){
                System.out.println("The type of product equal Телевизор");
            }
        }
        DriverManager.killDriver();

    }

    @Test
    public void sortPrice()
    {
        PageObject.navigateTo("https://hotline.ua/");
        WebElement alert = DriverManager.driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/span[1]"));
        alert.click();

        DriverManager.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WebElement input = DriverManager.driver.findElement(By.xpath("//*[@id=\"searchbox\"]"));
        input.click();
        input.sendKeys("телевизор");

        WebElement searchButton = DriverManager.driver.findElement(By.xpath("//*[@id=\"doSearch\"]"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(DriverManager.driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class ,'price-md')]")));

        WebElement filter = DriverManager.driver.findElement(By.xpath("//*[@id=\"page-search\"]/div[2]/div/div[1]/div[2]/ul/li/select"));
        filter.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-search\"]/div[2]/div/div[1]/div[2]/ul/li/select/option[2]")));

        WebElement chooseByPrice = DriverManager.driver.findElement(By.xpath("//*[@id=\"page-search\"]/div[2]/div/div[1]/div[2]/ul/li/select/option[2]"));
        chooseByPrice.click();


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

}


