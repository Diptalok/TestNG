package testScript.java.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrganizationsPage {
	
	public DeleteOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="selected_id") private WebElement checkBox;
	@FindBy(xpath="//input[@value=\"Send Mail\"]") private WebElement sendMail;
	@FindBy(name="Select") private WebElement select;
	@FindBy(name="ccmail") private WebElement cc;
	@FindBy(name="selectall") private WebElement allCheckBox;
	@FindBy(xpath="//input[@value=\"Delete\"]") private WebElement delete;
	
	public void clickOnCheckbox() {
		checkBox.click();
	}
	
	public void clickOnSendMail() {
		sendMail.click();
	}
	
	public void clickOnSelect() {
		select.click();
	}
	
	public void clickOnCC(String details) {
		cc.sendKeys(details);
	}
	
	public void clickOnSelectAllCheckbox() {
		allCheckBox.click();
	}
	
	public void clickOnDelete() {
		delete.click();
	}

}
