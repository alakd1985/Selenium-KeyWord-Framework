package utility;

public class Constant {
	// This is the list of System Variables
	// Declared as 'public', so that it can be used in other classes of this project
	// Declared as 'static', so that we do not need to instantiate a class object
	// Declared as 'final', so that the value of this variable can be changed
	// 'String' & 'int' are the data type for storing a type of value
	public static final String URL = "http://localhost:8888/index.php?action=Login&module=Users";
	public static final String Path_TestData = "./src/test/resources/dataEngine/DataEngine.xlsx";
	public static final String Path_OR = "D://Selenium Projects//KeyworddrivenFramework//src//test//java//keyword//OR.txt";
	public static final String File_TestData = "DataEngine.xlsx";
// ./src/test/java/keyword/OR.txt
	// List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;
	public static final int Col_TestScenarioID = 1;
	public static final int Col_ActionKeyword = 4;
	public static final int Col_PageObject = 3;
	public static final int Col_RunMode = 2;

	// List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "Test Steps";
	public static final String Sheet_TestCases = "Test Cases";

	// List of Test Data
	public static final String UserName = "admin";
	public static final String Password = "Toma*1996";
}
