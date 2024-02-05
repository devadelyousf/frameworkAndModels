package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodsHandel;

public class HomePage extends MethodsHandel {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By loginLink=By.cssSelector(".ico-login");

    public LoginPage clickOnLoginButton(){
        click(loginLink);
        return new LoginPage(driver);
    }
}
