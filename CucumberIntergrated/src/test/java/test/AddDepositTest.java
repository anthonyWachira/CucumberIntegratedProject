package test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddDepositPage;
import page.DashboradPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddDepositTest {
	
	
	ExcelReader reader=new ExcelReader("./Data/data.xlsx");
	
	String Loginemail=reader.getCellData("Sheet1", "Loginemail", 2);
	String password=reader.getCellData("Sheet1", "password", 2);

	@Test
	
	public void AddDepositToVeryfyDepositPosted() throws InterruptedException {
	
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");
	
		driver.get("http://techfios.com/test/billing/?ng=admin/");
	
		LoginPage logintotechfios= PageFactory.initElements(driver, LoginPage.class);

		logintotechfios.Login(Loginemail, password);
		
	
		DashboradPage dashboardPage = PageFactory.initElements(driver, DashboradPage.class);
	
		dashboardPage.waitForPage();
		
		dashboardPage.clickOnAddDepositButton();
	
		AddDepositPage addDepositPage = PageFactory.initElements(driver, AddDepositPage.class);
	
		addDepositPage.waitForPage();
	
		addDepositPage.selectFromDropDownForAccount("AutoAccount");
		addDepositPage.ClearTheDateAndInput("2019-06-12");
		addDepositPage.clickAway();
		Thread.sleep(500);
	
		Random random = new Random();
		
		String expectedDescription = "TestDescription" + String.valueOf(random.nextInt(999));
		String expectedAmount = String.valueOf(random.nextInt(99999));
	
		addDepositPage.inputDescriptionAndAmount(expectedDescription, expectedAmount);
	
		addDepositPage.clickOnSubmitButton();
		
		
	     driver.close();
		 driver.quit();
	}
}