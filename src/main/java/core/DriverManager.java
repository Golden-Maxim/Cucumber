package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public  static  WebDriver driver;
    private DriverManager(){}

    public static WebDriver getDriver(){
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver killDriver(){
        driver.close();
        return driver;
    }
}
