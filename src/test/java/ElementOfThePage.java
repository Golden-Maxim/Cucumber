import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementOfThePage {
    public static WebElement webElement;

    public static WebElement getElement(String paths ){

        webElement.findElement(By.xpath(paths));

        return webElement;
    }
}
