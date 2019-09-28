package stepDefinations;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.AddContact;
import page.AddDepositPage;
import page.DashboradPage;
import page.HomePage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class stepDefination {
	
	ExcelReader reader = new ExcelReader("./Data/data.xlsx");
	
	
	String Loginemail=reader.getCellData("Sheet1", "Loginemail", 2);
	String password=reader.getCellData("Sheet1", "password", 2);
	String Name=reader.getCellData("Sheet1", "Name", 2);
	String Company=reader.getCellData("Sheet1", "Company", 2);
	String Email=reader.getCellData("Sheet1", "Email", 2);
	String phone=reader.getCellData("Sheet1", "phone", 2);
	String address=reader.getCellData("Sheet1", "address", 2);
	String City=reader.getCellData("Sheet1", "City", 2);
	String State=reader.getCellData("Sheet1", "State", 2);
	String Zip=reader.getCellData("Sheet1", "Zip", 2);

	static WebDriver driver;

	@Given("^User is on theTechfios home page$")
	public void user_is_on_theTechfios_home_page() throws Throwable {
		
		driver= BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");
		
	}

	@When("^User login with valid username and passord$")
	public void user_login_with_valid_username_and_passord() throws Throwable {
		
		LoginPage logintotechfios= PageFactory.initElements(driver, LoginPage.class);
		logintotechfios.Login(Loginemail, password);

		
	}

	@Then("^User lands on the dashboard page$")
	public void user_lands_on_the_dashboard_page() throws Throwable {
		System.out.println("Dashbord is displayed");
	    
	}
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.close();
	    driver.quit();
	}

	@Then("^User navigates to add contact page$")
	public void user_navigates_to_add_contact_page() throws Throwable {
		HomePage home= PageFactory.initElements(driver, HomePage.class);
		
		home.NavigateToAddContact();
	}

	@Then("^user fills up the page with relevant details$")
	public void user_fills_up_the_page_with_relevant_details() throws Throwable {
		AddContact contact=PageFactory.initElements(driver, AddContact.class);
		
		contact.FillingUpAdressForm(Name, Company, Email, phone, address, City, State, Zip);
      
	}

	@Then("^User navigates to add dashboard page and click on adddeposit$")
	public void user_navigates_to_add_dashboard_page_and_click_on_adddeposit() throws Throwable {
		DashboradPage dashboardPage = PageFactory.initElements(driver, DashboradPage.class);
		
		dashboardPage.waitForPage();
		
		dashboardPage.clickOnAddDepositButton();
	}

	@Then("^user naviagtes to adddeposit page and fills up the page$")
	public void user_naviagtes_to_adddeposit_page_and_fills_up_the_page() throws Throwable {
		AddDepositPage addDepositPage = PageFactory.initElements(driver, AddDepositPage.class);
		
		addDepositPage.waitForPage();
	
		addDepositPage.selectFromDropDownForAccount("AutoAccount");
		addDepositPage.ClearTheDateAndInput("2019-07-12");
		addDepositPage.clickAway();
		Thread.sleep(500);
	
		Random random = new Random();
		
		String expectedDescription = "TestDescription" + String.valueOf(random.nextInt(999));
		String expectedAmount = String.valueOf(random.nextInt(99999));
	
		addDepositPage.inputDescriptionAndAmount(expectedDescription, expectedAmount);
	
		addDepositPage.clickOnSubmitButton();
	}

}
