package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandling {
	
	public static WebDriver driver;
	
	public static void setup(String baseUrl) {
		System.setProperty("webdriver.gecko.driver", "E:\\Automation Downloads\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	public static void click(String xPath) {
		driver.findElement(By.xpath(xPath)).click();
	}

	public static void sendKeys(String xPath, String value) {
		driver.findElement(By.xpath(xPath)).sendKeys(value);
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		setup("https://classic.crmpro.com/index.html");
		sendKeys("//input[@name ='username']", "shweta1104");
		sendKeys("//input[@name ='password']", "shweta.1104");
		Thread.sleep(3000);
		click("//input[@type='submit']");
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		click("//a[contains(text(),'Contacts')]");

	}

}
