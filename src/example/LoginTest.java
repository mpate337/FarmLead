package example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    public String baseUrl = "https://demo.combyne.ag/login";
    String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
    public WebDriver driver ; 
     
  @Test
  public void verifyHomepageTitle() {
       
      System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.chrome.driver", driverPath);
      driver = new ChromeDriver();
      driver.get(baseUrl);
      //String expectedTitle = "Welcome: Mercury Tours";
      //String actualTitle = driver.getTitle();
      //Assert.assertEquals(actualTitle, expectedTitle);
      //driver.close();
  }
}
