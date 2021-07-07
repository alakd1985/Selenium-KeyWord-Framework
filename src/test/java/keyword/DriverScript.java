package keyword;

import org.openqa.selenium.WebDriver;

import config.ActionKeyWord;
import utility.ExcelUtils;

public class DriverScript {
	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		// Declaring the path of the Excel file with the name of the Excel file
		String sPath = "./src/test/resources/dataEngine/DataEngine.xlsx";
		// Here we are passing the Excel path and SheetName as arguments to connect with
		// Excel file
		ExcelUtils.setExcelFile(sPath, "Test Steps");

		// Hard coded values are used for Excel row & columns for now
		// In later chapters we will replace these hard coded values with varibales
		// This is the loop for reading the values of the column 3 (Action Keyword) row
		// by row
		for (int iRow = 1; iRow <= 9; iRow++) {
			// Storing the value of excel cell in sActionKeyword string variable
			String sActionKeyword = ExcelUtils.getCellData(iRow, 3);
			if (sActionKeyword.equals("openBrowser")) {
				// This will execute if the excel cell value is 'openBrowser'
//Action Keyword is called here to perform action
				ActionKeyWord.openBrowser();
			} else if (sActionKeyword.equals("navigateWebsite")) {
				ActionKeyWord.navigateWebsite();
			} else if (sActionKeyword.equals("inputUsername")) {
				ActionKeyWord.inputUsername();
			} else if (sActionKeyword.equals("inputPassword")) {
				ActionKeyWord.inputPassword();
			} else if (sActionKeyword.equals("doLogin")) {
				ActionKeyWord.doLogin();
			} else if (sActionKeyword.equals("doClose")) {
				ActionKeyWord.doClose();
			}
		}

		/*
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		 * driver.findElement(By.name("user_name")).sendKeys("admin");
		 * driver.findElement(By.name("user_password")).sendKeys("Toma*1996");
		 * driver.findElement(By.id("submitButton")).click(); driver.quit();
		 */
	}
}
