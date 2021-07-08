package config;

import static keyword.DriverScript.OR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Constant;

public class ActionKeyWord {
	public static WebDriver driver;

	public static void openBrowser(String object) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void navigateWebsite(String object) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.URL);
	}

	public static void inputUsername(String object) {
		// driver.findElement(By.name("user_name")).sendKeys(Constant.UserName);
		driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constant.UserName);
	}

	public static void inputPassword(String object) {
		driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constant.Password);
	}

	public static void doLogin(String object) {
		driver.findElement(By.xpath(OR.getProperty(object))).click();
	}

	public static void doClose(String object) {
		driver.quit();
	}
}
