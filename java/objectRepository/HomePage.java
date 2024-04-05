package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText  = "Organizations") private WebElement organization;
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement adminstrator;
	@FindBy (linkText  = "Organizations") private WebElement signOut;
	
	public void clickOnOrganizations() {
		organization.click();
	}
	
	public void signOut() {
		signOut.click();
	}

	public WebElement getAdminstrator() {
		return adminstrator;
	}

}
