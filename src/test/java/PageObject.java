import core.DriverManager;
import org.openqa.selenium.WebElement;

public class PageObject {
    public static void navigateTo(String url){
        DriverManager.getDriver().get(url);
    }


}
