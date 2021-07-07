package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionKeyWord {
	private static WebDriver driver = null;

	public static void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void navigateWebsite() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	}

	public static void inputUsername() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
	}

	public static void inputPassword() {
		driver.findElement(By.name("user_password")).sendKeys("Toma*1996");
	}

	public static void doLogin() {
		driver.findElement(By.id("submitButton")).click();
	}

	public static void doClose() {
		driver.quit();
	}
}
