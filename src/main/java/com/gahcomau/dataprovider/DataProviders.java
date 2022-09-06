/**
 * 
 */
package com.gahcomau.dataprovider;

import org.testng.annotations.DataProvider;

import com.gahcomau.utility.ExcelLibraryHomePageService;
import com.gahcomau.utility.ExcelLibraryLoginId;
import com.gahcomau.utility.ExcelLibraryNewUserOrderPageTest;
import com.gahcomau.utility.ExcelLibraryServiceMainTopic;
import com.gahcomau.utility.ExcelLibraryTurnitin;
import com.gahcomau.utility.Log;
import com.gahcomau.utility.NewExcelLibrary;
import com.gahcomau.utility.ExcelLibrarySamplesPage;

/**
 * @author user
 *
 */
public class DataProviders {

	NewExcelLibrary obj1 = new NewExcelLibrary();
	ExcelLibraryNewUserOrderPageTest obj2 = new ExcelLibraryNewUserOrderPageTest(); // new User order page test

	ExcelLibraryHomePageService obj3 = new ExcelLibraryHomePageService();
	ExcelLibraryLoginId obj4 = new ExcelLibraryLoginId();
	
	ExcelLibraryServiceMainTopic obj5 = new ExcelLibraryServiceMainTopic();

	ExcelLibrarySamplesPage obj6 = new ExcelLibrarySamplesPage();
	
	ExcelLibraryTurnitin obj9 = new ExcelLibraryTurnitin();
	
	
//*********************************************** Test Data Sheet Pricing Module *************************************************	
	@DataProvider(name = "turnitin")
	public Object[][] getTurnitin() {

		Log.info("Retriving Data From gahau Sheet");
		int rows = obj9.getRowCount("Abcd");
		// Total Columns
		int column = obj9.getColumnCount("Abcd");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj9.getCellData("Abcd", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "management")
	public Object[][] getSubManagement() {

		Log.info("Retriving Data From TestData Sheet");
		int rows = obj1.getRowCount("Management");
		// Total Columns
		int column = obj1.getColumnCount("Management");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj1.getCellData("Management", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "finance")
	public Object[][] getSubFinance() {

		Log.info("Retriving Data From TestData Sheet");
		int rows = obj1.getRowCount("Finance");
		// Total Columns
		int column = obj1.getColumnCount("Finance");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj1.getCellData("Finance", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "tourism")
	public Object[][] getSubTourism() {

		Log.info("Retriving Data From TestData Sheet");
		int rows = obj1.getRowCount("Tourism");
		// Total Columns
		int column = obj1.getColumnCount("Tourism");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj1.getCellData("Tourism", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "law")
	public Object[][] getSubLaw() {

		Log.info("Retriving Data From TestData Sheet");
		int rows = obj1.getRowCount("Law");
		// Total Columns
		int column = obj1.getColumnCount("Law");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj1.getCellData("Law", j, i + 2);
			}
		}
		return data;
	}
	
	
	//*********************************************** Test Data Sheet Pricing Module*************************************************	


	@DataProvider(name = "orderpage")
	public Object[][] getNewUserOrderPage() {
		Log.info("Retriving Data From Order Module Sheet");

		int rows = obj2.getRowCount("OrderPage");
		// Total Columns
		int column = obj2.getColumnCount("OrderPage");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj2.getCellData("OrderPage", j, i + 2);
			}
		}
		return data;
	}
	

	@DataProvider(name = "homepage")
	public Object[][] getHomePageServiceMainSubjectTopic() {
		Log.info("Retriving Data From Services Sheet");

		int rows = obj3.getRowCount("HomePage");
		Log.info("Data Copunt in data provider 3:" + rows);
		// Total Columns
		int column = obj3.getColumnCount("HomePage");
		Log.info("Data Copunt in data provider 3 :" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 3 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj3.getCellData("HomePage", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "homepage1")
	public Object[][] getHomePageServiceMainTopic() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("HomePage");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("HomePage");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("HomePage", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "email")
	public Object[][] getNewEmailId() {
		Log.info("Retriving Data From login Sheet");

		int rows = obj4.getRowCount("Email");
		Log.info("Data Copunt in data provider email:" + rows);
		// Total Columns
		int column = obj4.getColumnCount("Email");
		Log.info("Data Copunt in data provider email :" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider email :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj4.getCellData("Email", j, i + 2);
			}
		}
		return data;
	}

	//************************************************** Home page services ************************
	
	@DataProvider(name = "assignmentsubject")
	public Object[][] getHomePageServiceMainTopicAS() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Assignment_Subjects ");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Assignment_Subjects ");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Assignment_Subjects ", j, i + 2);
			}
		}
		return data;
	}
	
	

	@DataProvider(name = "engineeringsubjects")
	public Object[][] get() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Engineering_Subjects ");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Engineering_Subjects ");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Engineering_Subjects ", j, i + 2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name = "managementsubject")
	public Object[][] get3() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Management_Subjects ");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Management_Subjects ");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Management_Subjects ", j, i + 2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name = "dissertationhelp")
	public Object[][] get4() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Dissertation_Help ");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Dissertation_Help ");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Dissertation_Help ", j, i + 2);
			}
		}
		return data;
	}
	
	@DataProvider(name = "lawsubjects")
	public Object[][] get5() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Law_Subjects");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Law_Subjects");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Law_Subjects", j, i + 2);
			}
		}
		return data;
	}
	
	
	
	@DataProvider(name = "courseworkhelp")
	public Object[][] get6() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Coursework_Help ");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Coursework_Help ");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Coursework_Help ", j, i + 2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name = "assignmentcities")
	public Object[][] get7() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Assignment_Cities ");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Assignment_Cities ");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Assignment_Cities ", j, i + 2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name = "thesishelp")
	public Object[][] get8() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Thesis_Help ");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Thesis_Help ");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Thesis_Help ", j, i + 2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name = "homeworkservices")
	public Object[][] get9() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Homework_Services ");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Homework_Services ");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Homework_Services ", j, i + 2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name = "essaysubject")
	public Object[][] get10() {
		
		Log.info("Retriving Data From Services_main_topic_gah au Sheet");


		int rows = obj5.getRowCount("Essay_Subjects ");
		Log.info("Data Copunt in data provider 5:" + rows);
		// Total Columns 
		int column = obj5.getColumnCount("Essay_Subjects ");
		Log.info("Data Copunt in data provider 5:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 5 :" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj5.getCellData("Essay_Subjects ", j, i + 2);
			}
		}
		return data;
	}
	
	//****************************************************Samples page ********************************
	
	@DataProvider(name = "sample")
	public Object[][] getSamplePage() {
		
		Log.info("Retriving Data From Samples Titl Sheet");


		int rows = obj6.getRowCount("SampleHeading");
		Log.info("Data Copunt in data provider 6:" + rows);
		// Total Columns 
		int column = obj6.getColumnCount("SampleHeading");
		Log.info("Data Copunt in data provider 6:" + column);
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];
		Log.info("Data Copunt in data provider 6:" + data);


		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj6.getCellData("SampleHeading", j, i + 2);
			}
		}
		return data;
	}
	
	
	

}
