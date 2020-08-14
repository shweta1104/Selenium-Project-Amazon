package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopUpHandle {
	
	public static WebDriver driver;
	
	// setup method
	public static void setup(String baseUrl) {
		System.setProperty("webdriver.gecko.driver", "E:\\Automation Downloads\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	//Click on a webelement
	public static void click(String xPath) {
		driver.findElement(By.xpath(xPath)).click();
	}
	
	//WebElement Sendkeys methods
	public static void sendkeys(String xPath, String value) {
		driver.findElement(By.xpath(xPath)).sendKeys(value);
	}
	//Close browser
	public static void close() {
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setup("https://www.rediff.com");
		String xpath ="//a[contains(text(),'Sign in')]";
		click(xpath);
		click("//input[@type='submit' and @name='proceed']");
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		//alert.dismiss();
		
		close();
		
		setup("https://html.com/input-type-file/");
		sendkeys("//input[@id='fileupload']","C:\\Users\\Shweta-PC\\Desktop\\IMG_1233.JPG");

	}

}
