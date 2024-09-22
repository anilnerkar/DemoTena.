package TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
		Thread.sleep(3000);

		List<WebElement> alllist = driver.findElements(By.xpath("//ul/li[@class='sbct PZPZlf']"));
		System.out.println("List of all options:" + alllist.size());

		for (WebElement ele : alllist) {
			String text = ele.getText();
			// System.out.println("All autosuggestion options are :"+text);

			if (text.equalsIgnoreCase("Selenium webdriver")) {
				System.out.println("Selected Element is :" + ele.getText());

				ele.click();
			}
		}

	}
}
