package keyword;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import config.ActionKeyWord;
import utility.Constant;
import utility.ExcelUtils;

public class DriverScript {
	public static Properties OR;
	public ActionKeyWord actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	// This is reflection class object, declared as 'public'So that it can be used
	// outside the scope of main[] method
	public Method method[];
	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;

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
				method[i].invoke(actionKeywords, sPageObject);
//Once any method is executed, this break statement will take the flow outside of for loop
				break;
			}
		}
	}

	private void execute_TestCase() throws Exception {
		// This will return the total number of test cases mentioned in the Test cases
		// sheet
		int iTotalTestCases = ExcelUtils.getRowCount(Constant.Sheet_TestCases);
		// This loop will execute number of times equal to Total number of test cases
		for (int iTestcase = 1; iTestcase <= iTotalTestCases; iTestcase++) {
			// This is to get the Test case name from the Test Cases sheet
			sTestCaseID = ExcelUtils.getCellData(iTestcase, Constant.Col_TestCaseID, Constant.Sheet_TestCases);
			// This is to get the value of the Run Mode column for the current test case
			sRunMode = ExcelUtils.getCellData(iTestcase, Constant.Col_RunMode, Constant.Sheet_TestCases);
			// This is the condition statement on RunMode value
			if (sRunMode.equals("Yes")) {
				// Only if the value of Run Mode is 'Yes', this part of code will execute
				iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constant.Col_TestCaseID, Constant.Sheet_TestSteps);
				iTestLastStep = ExcelUtils.getTestStepsCount(Constant.Sheet_TestSteps, sTestCaseID, iTestStep);
				// This loop will execute number of times equal to Total number of test steps
				for (; iTestStep <= iTestLastStep; iTestStep++) {
					sActionKeyword = ExcelUtils.getCellData(iTestStep, Constant.Col_ActionKeyword,
							Constant.Sheet_TestSteps);
					sPageObject = ExcelUtils.getCellData(iTestStep, Constant.Col_PageObject, Constant.Sheet_TestSteps);
					execute_Actions();
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData);
		String Path_OR = Constant.Path_OR;
		FileInputStream fs = new FileInputStream(Path_OR);
		OR = new Properties(System.getProperties());
		OR.load(fs);
		DriverScript startEngine = new DriverScript();
		startEngine.execute_TestCase();
	}
}
