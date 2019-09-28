package page;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddDepositPage extends BasePage {

	WebDriver driver; // Global
	// Every Page must have a constructor to invite the driver

	public AddDepositPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library 7 total
	// @FindBy(how = How.XPATH, using =
	// "//select[@id='account']/option[@value='Syed']" to find individual name)
	@FindBy(how = How.XPATH, using = "//select[@id='account']")
	WebElement AcccountDropDown;
	@FindBy(how = How.ID, using = "description")
	WebElement DescriptionField;
	@FindBy(how = How.ID, using = "amount")
	WebElement AmountField;
	@FindBy(how = How.ID, using = "submit")
	WebElement SubmitButton;
	@FindBy(how = How.XPATH, using = "//button[@data-dismiss='alert']")
	WebElement DepositSuccessMsg;
	@FindBy(how = How.XPATH, using = "//h5[text() = 'Add Deposit']")
	WebElement AddDepositPanelHeading;
	@FindBy(how = How.ID, using = "date")
	WebElement DateField;

	// Methods to interact with the elements
	public void waitForPage() {
		try {
			waitForElement(AddDepositPanelHeading, driver);
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Page atitle did not display");
		}
	}

	public void fillInTheAddDepositForm(String description, String amount) {
		AcccountDropDown.click();
		DescriptionField.sendKeys(description);
		AmountField.sendKeys(amount);
		SubmitButton.click();
	}

	public void waitForSuccessMsg() {
		waitForElement(DepositSuccessMsg, driver);
	}

	public void selectFromDropDownForAccount(String string) {
		Select AccountDropDown = new Select(AcccountDropDown);
		AccountDropDown.selectByVisibleText(string);
	}

	public void ClearTheDateAndInput(String string) {
		DateField.clear();
		DateField.sendKeys(string);
		DateField.sendKeys(Keys.TAB);
	}

	public void inputDescriptionAndAmount(String expectedDescription, String expectedAmount) {
		DescriptionField.sendKeys(expectedDescription);
		AmountField.sendKeys(expectedAmount);
	}

	public void clickAway() {
		AddDepositPanelHeading.click();
	}

	public void clickOnSubmitButton() {
		SubmitButton.click();
	}

	public boolean isSuccessMsgDisplayed() {
		try {
			return DepositSuccessMsg.isDisplayed();
		} catch (NoSuchElementException e) {
			throw new RuntimeException("I Failed The Test, Not JAVA");
		}
	}
}
