package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Loginpage;



public class testcase1 {
	
	WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet sheet;

	
	@BeforeMethod
	public void lunchBrowser()  {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/home/sushilnayaktecn/Downloads/geckodriver");
              	
	    driver = new ChromeDriver();
		
		driver.get("https://github.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);

		
	}
	
	@Test
	public void Logintest() throws IOException {
		
		FileInputStream file = new FileInputStream("Excellread.xlsx");
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheet("report");
		//driver.quit();
		
		 //to find a string
		//*[contains(text(),'Welcome')]
		
		String UserName = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(0).getStringCellValue();
		
		Loginpage obj = new Loginpage(driver);
		obj.Login(UserName,Password);
	 
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}

}
