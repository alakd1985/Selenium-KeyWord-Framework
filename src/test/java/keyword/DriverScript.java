package keyword;

import java.lang.reflect.Method;

import config.ActionKeyWord;
import utility.ExcelUtils;

public class DriverScript {
	public static ActionKeyWord actionKeywords;
	public static String sActionKeyword;
	public static Method method[];

	DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeyWord();
		method = actionKeywords.getClass().getMethods();
	}

	private static void execute_Actions() throws Exception {
		for (int i = 3; i < method.length; i++) {
			if (method[i].getName().equals(sActionKeyword)) {
				break;
			}
		}

	}

	public static void main(String[] args) throws Exception {

		String sPath = "./src/test/resources/dataEngine/DataEngine.xlsx";
		ExcelUtils.setExcelFile(sPath, "Test Steps");

		for (int iRow = 1; iRow <= 9; iRow++) {
			sActionKeyword = ExcelUtils.getCellData(iRow, 3);
			execute_Actions();
		}
	}
}
