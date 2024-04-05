package testScript;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testScript.java.objectRepository.CreateNewOrganizationsPage;
import testScript.java.objectRepository.DeleteOrganizationsPage;
import testScript.java.objectRepository.HomePage;
import testScript.java.objectRepository.OrganizationInformationPage;
import testScript.java.objectRepository.OrganizationsPage;


public class OrganizationsModule2 extends testScript.java.genericUtilities.TestNGBaseClass{
	
	@Test
	public void OrganizationsModuleTest() throws Exception {
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizations();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnAddOrganization();
		
		CreateNewOrganizationsPage cp = new CreateNewOrganizationsPage(driver);
		String OrganizationName = eUtil.readData("Sheet1", 1, 2);
		cp.fillOrganizationName(OrganizationName);
		WebElement Industry = cp.getSelectIndustry();
		String IndustryName = eUtil.readData("Sheet1", 1, 3);
		sUtil.handleDropdown(driver, Industry, IndustryName);
		sUtil.scrollDown(driver);
		cp.clickOnRadio();
		String IndustryState = eUtil.readData("Sheet1", 1, 4);
		cp.fillBillState(IndustryState);
		Thread.sleep(2000);
		cp.clickOnSave();
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String OrgName = oip.getOrganizationName();
		sUtil.validation(OrganizationName, OrgName);
		sUtil.takeScreenshot(driver, "Organization Information");
		
		DeleteOrganizationsPage dp = new DeleteOrganizationsPage(driver);
		sUtil.navigateBackward(driver);
		dp.clickOnCheckbox();
		dp.clickOnSendMail();
		dp.clickOnSelect();
		sUtil.switchWindow(driver);
		dp.clickOnCC(eUtil.readData("Sheet1", 2, 4));
		sUtil.takeScreenshot(driver, "switching window validation");
		sUtil.closeBrowser(driver);
		sUtil.switchMainWindow(driver);
		dp.clickOnDelete();
		sUtil.acceptAlert(driver);
		sUtil.takeScreenshot(driver, "Deletion successful validation");
		
		WebElement mouseActions = hp.getAdminstrator();
		sUtil.mouseHover(driver, mouseActions);
		hp.signOut();
		
	}
	

}
