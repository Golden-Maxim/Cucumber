package core;

import org.openqa.selenium.WebElement;

public class MyMethods {

    public static void checkPrice(WebElement [] price){
        for (int i = 0; i < price.length;i++){
            String priceStr = price[i].getText();
            Integer priceValue = Integer.parseInt(priceStr.replace(" ", "").replace("грн", ""));
            if(priceValue > 10000) {
                System.out.println(priceValue);
            }
        }
        System.out.println("Pages does not have price more than 10000");
    }

    public static void checkDescriptionProduct(){

    }
}
