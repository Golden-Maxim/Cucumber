import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageObject {

    public static void navigateTo(String url){
        DriverManager.getDriver().get(url);
    }




    public static  void Button(String path){
        DriverManager.driver.findElement(By.xpath(path)).click();

    }


}
