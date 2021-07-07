package keyword;

import java.lang.reflect.Method;

import config.ActionKeyWord;
import utility.ExcelUtils;

public class DriverScript {
	public ActionKeyWord actionKeywords;
	public static String sActionKeyword;
	public Method method[];

	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeyWord();
		method = actionKeywords.getClass().getMethods();
	}

	public void execute_Actions() throws Exception {
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().equals(sActionKeyword)) {
				method[i].invoke(actionKeywords);
				break;
			}
		}

	}

	public static void main(String[] args) throws Exception {

		String sPath = "./src/test/resources/dataEngine/DataEngine.xlsx";
		ExcelUtils.setExcelFile(sPath, "Test Steps");

		for (int iRow = 1; iRow <= 9; iRow++) {
			sActionKeyword = ExcelUtils.getCellData(iRow, 3);

			DriverScript dScript = new DriverScript();
			dScript.execute_Actions();
		}
	}
}
