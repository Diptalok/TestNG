package testScript.java.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationsPage {
	public CreateNewOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname") private WebElement OrganizationName;
	@FindBy(id="bill_state") private WebElement billState;
	@FindBy(xpath="//input[contains(@onclick,\"return copyAddressL\")]") private WebElement radiobtn;
	@FindBy(name="industry") private WebElement SelectIndustry;
	@FindBy(xpath="//input[@value=\"  Save  \"]") private WebElement save;
	
	
	public WebElement getSelectIndustry() {
		return SelectIndustry;
	}

	public void fillOrganizationName(String name) {
		OrganizationName.sendKeys(name);
	}
	
	public void fillBillState(String name) {
		billState.sendKeys(name);
	}
	
	public void clickOnRadio() {
		radiobtn.click();
	}
	
	public void clickOnSave() {
		save.click();
	}

}
