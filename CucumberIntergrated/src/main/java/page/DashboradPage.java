package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboradPage extends BasePage {
	WebDriver driver;

	public DashboradPage(WebDriver driver) {

		this.driver = driver;

	}

//Element Library or repository
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement PageTitle;
	@FindBy(how = How.LINK_TEXT, using = "Add Deposit")
	WebElement AddDepositButton;
	
	public void waitForPage() {
		waitForElement(PageTitle, driver);
	}

	public void clickOnAddDepositButton() {
		AddDepositButton.click();
	}

	

	public void waitForDashBoardPage() {
		waitForElement(PageTitle, driver);

	}

	public boolean isDashBoardPageTitleDisplayed() {
		return PageTitle.isDisplayed();
	}

}
