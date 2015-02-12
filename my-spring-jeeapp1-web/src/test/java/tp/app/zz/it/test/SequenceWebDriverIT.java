package tp.app.zz.it.test;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SequenceWebDriverIT {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();//visible browser during test
    driver = new HtmlUnitDriver();  //invisible browser (with limitations)
	((HtmlUnitDriver)driver).setJavascriptEnabled(true);
	
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  public void testIT() throws Exception {
    driver.get(baseUrl + "/my-spring-jeeapp1-web/");
    driver.findElement(By.linkText("bienvenue")).click();
    driver.findElement(By.linkText("conversion")).click();
    driver.findElement(By.id("frm:m1")).clear();
    driver.findElement(By.id("frm:m1")).sendKeys("euro");
    driver.findElement(By.id("frm:m2")).clear();
    driver.findElement(By.id("frm:m2")).sendKeys("dollar");
    driver.findElement(By.id("frm:montantInput")).clear();
    driver.findElement(By.id("frm:montantInput")).sendKeys("60");
    driver.findElement(By.id("frm:convertButton")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
/*
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }*/
}

