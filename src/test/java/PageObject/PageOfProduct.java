package PageObject;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageOfProduct {

  //  public By descriptionProduct = By.xpath("//ul[contains(@class,'breadcrumbs')]");

    public PageOfProduct checkDescription(){

        WebElement listofparameters = DriverManager.driver.findElement(By.xpath("//ul[contains(@class,'breadcrumbs')]"));

        String str = listofparameters.getText();
        System.out.println(str);

        String temp[] = str.trim().split("\\s+");
        for (int i = 0;i < temp.length;i++){
            if(temp[i].contains("Телевізори")){
                System.out.println("The type of product contains Телевізори");
            }
        }
        return new PageOfProduct();
    }
}
