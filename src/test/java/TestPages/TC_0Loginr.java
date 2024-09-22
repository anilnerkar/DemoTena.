package TestPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_0Loginr {

	WebDriver driver;

	@BeforeMethod
	@Parameters("Browser")
	public void setUp(String Browser) 
	{
		switch(Browser.toLowerCase())
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--headless=new--");
			 driver = new ChromeDriver(op);
			 break;
		
		case "firefox":
		
			System.setProperty("geckodriver.gecko.driver", "./Drivers\\geckodriver.exe");
			FirefoxOptions ops = new FirefoxOptions();
			ops.addArguments("--headless=new--");
			 driver = new FirefoxDriver(ops);
			 break;
		
		}
	}

	@Test
	public void verifyTitlePage() {
		driver.get("https://www.tendable.com/contact-us");
		driver.findElement(By.xpath("(//a[normalize-space()='Contact Us'])[1]")).click();
		System.out.println("click");

		WebElement contactus = driver.findElement(By.xpath("(//button[text()='Contact'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", contactus);

		System.out.println("click on option");
		// driver.quit();

		driver.findElement(By.xpath("(//input[@id='form-input-fullName'])[1]")).sendKeys("anny");
		driver.findElement(By.id("form-input-organisationName")).sendKeys("Tenl");

		driver.findElement(By.id("form-input-cellPhone")).sendKeys("12345");

		driver.findElement(By.id("form-input-email")).sendKeys("abc@23gmail.com");
		System.out.println("click on email");
		driver.findElement(By.id("form-input-jobRole"));
		driver.findElement(By.id("form-input-message"));
		WebElement selctdrop = driver.findElement(By.id("form-input-consentAgreed-0"));
		js.executeScript("arguments[0].click();", selctdrop);

		WebElement submit = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		js.executeScript("arguments[0].click();", submit);
		System.out.println("click on sublit");
		String ExpectedTitle="Contact us | Quality Improvement Solution | Tendable | Tendable";
	    String ActuatTitle = driver.getTitle();
	    Assert.assertEquals(ActuatTitle, ExpectedTitle);
	    
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
