package keyword;

import java.lang.reflect.Method;

import config.ActionKeyWord;
import config.Constant;
import utility.ExcelUtils;

public class DriverScript {
	public ActionKeyWord actionKeywords;
	public static String sActionKeyword;
	// This is reflection class object, declared as 'public'So that it can be used
	// outside the scope of main[] method
	public Method method[];

	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeyWord();
//This will load all the methods of the class 'ActionKeywords' in it.It will be like array of method, use the break point here and do the watch
		method = actionKeywords.getClass().getMethods();
	}

//This method contains the code to perform some action As it is completely different set of logic, which revolves around the action only,
//It makes sense to keep it separate from the main driver script This is to execute test step (Action)
	public void execute_Actions() throws Exception {
//This is a loop which will run for the number of actions in the Action Keyword class 
//method variable contain all the method and method.length returns the total number of methods
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().equals(sActionKeyword)) {
//In case of match found, it will execute the matched method
				method[i].invoke(actionKeywords);
//Once any method is executed, this break statement will take the flow outside of for loop
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String sPath = Constant.Path_TestData;
		ExcelUtils.setExcelFile(sPath, Constant.Sheet_TestSteps);
		for (int iRow = 1; iRow <= 9; iRow++) {
			sActionKeyword = ExcelUtils.getCellData(iRow, Constant.Col_ActionKeyword);
			DriverScript dScript = new DriverScript();
			dScript.execute_Actions();
		}
	}
}
