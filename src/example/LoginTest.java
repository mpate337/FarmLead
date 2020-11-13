package example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    public String baseUrl = "https://demo.combyne.ag/login";
    public String frgtpwdurl = "https://demo.combyne.ag/login/recover-account";
    public String createaccurl = "https://demo.combyne.ag/onboard/details";
    String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
    public WebDriver driver ; 
     
  @BeforeTest
  public void setproperty() {
       
      System.out.println("launching browser"); 
      System.setProperty("webdriver.chrome.driver", driverPath);
  
  }
  
  @Test(priority = 0)
  //Empty Email
  public void testcase1() {
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("password");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(1) > div > div.Input_error__230A0.Input_ctr-error__2Uenh > div.Input_caption__3AYcS")));
	  
	  String result1 = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[2]/div[2]")).getText();
	  Assert.assertEquals(result1, "Either a phone number or email is required.");
	  
	  driver.close();
  }
  
  @Test(priority = 1)
  //Invalid Email Format
  public void testcase2() {
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("abcxyz");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("password");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(1) > div > div.Input_error__230A0.Input_ctr-error__2Uenh > div.Input_caption__3AYcS")));
	  
	  //Assumed that this type of error should be shown because of invalid format
	  String result2 = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[2]/div[2]")).getText();
	  Assert.assertEquals(result2, "Please enter valid email id");
	  
	  driver.close();
  }
  
  @Test(priority = 2)
  //Not registered email id
  public void testcase3() {
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("abcxyz@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("password");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(1) > div > div.Input_error__230A0.Input_ctr-error__2Uenh > div.Input_caption__3AYcS")));
	  
	  String result2 = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[2]/div[2]")).getText();
	  Assert.assertEquals(result2, "Whoops! That email is not associated with an account.");
	  
	  driver.close();
  }
  
  @Test(priority = 3)
  //Empty password
  public void testcase4() {
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("abcxyz@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(2) > div > div.Input_error__230A0")));
	  
	  
	  String result2 = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[2]")).getText();
	  Assert.assertEquals(result2, "Please enter password");
	  
	  driver.close();
  }
  
  @Test(priority = 4)
  //Password not matched
  public void testcase5() {
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("abcxyz@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("password");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(2) > div > div.Input_error__230A0")));
	  
	  
	  String result2 = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[2]")).getText();
	  Assert.assertEquals(result2, "Password not matched");
	  
	  driver.close();
  }
  
  @Test(priority = 5)
  //Forget pwd link
  public void testcase7() {
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[6]")).click();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > div > div > form > div.RecovPasswdForm_button__3v6TK > input")));
	  
	  String url = driver.getCurrentUrl();
	  Assert.assertEquals(url, "https://demo.combyne.ag/login/recover-account");
	  
	  driver.close();
  }
  
  @Test(priority = 6)
  //Forget pwd - Empty email
  public void testcase8() {
	  driver = new ChromeDriver();
	  driver.get(frgtpwdurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > div > div > form > div.RecovPasswdForm_button__3v6TK > input")));
  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/div/div/form/div[5]/input")).click();
	  
	  String errormsg = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/div/div/form/div[4]/div/div[2]")).getText();
	  Assert.assertEquals(errormsg, "Please enter email");
	  
	  driver.close();
  }
  
  @Test(priority = 7)
  //Forget pwd - Invalid format email
  public void testcase9() {
	  driver = new ChromeDriver();
	  driver.get(frgtpwdurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > div > div > form > div.RecovPasswdForm_button__3v6TK > input")));
  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/div/div/form/div[4]/div/div[1]/fieldset/input")).sendKeys("abcxyz");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/div/div/form/div[5]/input")).click();
	  
	  String errormsg = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/div/div/form/div[4]/div/div[2]")).getText();
	  Assert.assertEquals(errormsg, "Please enter valid email");
	  
	  driver.close();
  }
  
  @Test(priority = 8)
  //Forget pwd - Not registered email
  public void testcase10() {
	  driver = new ChromeDriver();
	  driver.get(frgtpwdurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > div > div > form > div.RecovPasswdForm_button__3v6TK > input")));
  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/div/div/form/div[4]/div/div[1]/fieldset/input")).sendKeys("abcxyz@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/div/div/form/div[5]/input")).click();
	  
	  boolean errormsg = driver.findElement(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > div > div > form > div.RecovPasswdForm_input__n-Tmx > div > div.Input_error-message__26I3v.Input_ctr-error__1Oy3O")).isDisplayed();
	  Assert.assertEquals(errormsg, true);
	  
	  driver.close();
  }
  
  @Test(priority = 9)
  //Forget pwd - login link
  public void testcase12() {
	  driver = new ChromeDriver();
	  driver.get(frgtpwdurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > div > div > form > div.RecovPasswdForm_back-login__BXgeI")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/div/div/form/div[6]")).click();
	  
	  String url = driver.getCurrentUrl();
	  Assert.assertEquals(url, "https://demo.combyne.ag/login");
	  
	  driver.close();
  }
  
  @Test(priority = 10)
  //Create an account link
  public void testcase13() {
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[7]/span")).click();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  String url = driver.getCurrentUrl();
	  Assert.assertEquals(url, "https://demo.combyne.ag/onboard/details");
	  
	  driver.close();
  }
  
  @Test(priority = 11)
  //firstname-lastname empty
  public void testcase14() {
	  driver = new ChromeDriver();
	  driver.get(createaccurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(1) > div > div.Input_error__230A0.Input_ctr-error__2Uenh > div.Input_icon__2iLKp")));
	  
	  boolean firsterror = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[2]/div[1]")).isDisplayed();
	  boolean lasterror = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[2]/div[1]")).isDisplayed();
	  
	  Assert.assertEquals(firsterror, true);
	  Assert.assertEquals(lasterror, true);
	  
	  driver.close();
  }
  
  @Test(priority = 12)
  //firstname-lastname invalid format
  public void testcase15() {
	  driver = new ChromeDriver();
	  driver.get(createaccurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("1234");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("5678");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(1) > div > div.Input_error__230A0.Input_ctr-error__2Uenh > div.Input_icon__2iLKp")));
	  
	  String firsterror = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[2]/div[1]")).getText();
	  String lasterror = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[2]/div[1]")).getText();
	  
	  Assert.assertEquals(firsterror, "Please enter valid first name");
	  Assert.assertEquals(lasterror, "Please enter valid last name");
	  
	  driver.close();
  }
  
  @Test(priority = 13)
  //empty email in create account
  public void testcase16() {
	  driver = new ChromeDriver();
	  driver.get(createaccurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("first");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("last");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[3]/div/div[1]/fieldset/div/input")).sendKeys("");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(3) > div > div.Input_error__230A0.Input_ctr-error__2Uenh > div.Input_icon__2iLKp")));
	  
	  boolean emailerror = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[3]/div/div[2]/div[1]")).isDisplayed();
	  Assert.assertEquals(emailerror, true);
	  
	  driver.close();
  }
  
  @Test(priority = 14)
  //email invalid format in create account
  public void testcase17() {
	  driver = new ChromeDriver();
	  driver.get(createaccurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("first");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("last");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[3]/div/div[1]/fieldset/div/input")).sendKeys("abcxyz");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(3) > div > div.Input_error__230A0.Input_ctr-error__2Uenh > div.Input_icon__2iLKp")));
	  
	  boolean emailerror = driver.findElement(By.className("Input_caption__3AYcS")).isDisplayed();
	  Assert.assertEquals(emailerror, true);
	  
	  driver.close();
  }
  
  @Test(priority = 15)
  //functionality of success login
  public void testcase19() {
	  driver = new ChromeDriver();
	  driver.get(createaccurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[1]/div/div[1]/fieldset/div/input")).sendKeys("first");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[2]/div/div[1]/fieldset/div/input")).sendKeys("last");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[3]/div[3]/div/div[1]/fieldset/div/input")).sendKeys("marmik2601@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[5]/input")).click();
  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_fields__2N0VA > div:nth-child(3) > div > div.Input_error__230A0.Input_ctr-error__2Uenh > div.Input_icon__2iLKp")));
	  
	  boolean emailerror = driver.findElement(By.className("Input_caption__3AYcS")).isDisplayed();
	  Assert.assertEquals(emailerror, false);
	  
	  driver.close();
  }
  
  @Test(priority = 16)
  //Create an account link
  public void testcase20() {
	  driver = new ChromeDriver();
	  driver.get(createaccurl);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[1]/form/div/div[6]/span")).click();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui > div > div.OnBoardingPage_modal___B3EI > form > div > div.Onboard_button__3K0AZ > input")));
	  
	  String url = driver.getCurrentUrl();
	  Assert.assertEquals(url, baseUrl);
	  
	  driver.close();
  }
}
