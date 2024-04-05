package testScript.java.genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import testScript.java.objectRepository.HomePage;
import testScript.java.objectRepository.LogInPage;

public class TestNGBaseClass {
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public SeleniumUtilities sUtil = new SeleniumUtilities();
	public WebDriver driver;
	public static WebDriver Sdriver;
	
	@BeforeSuite(groups = "SmokeSuite")
	public void DBconfig() {
		System.out.println("====DB connection successful====");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void browserLaunch(/*String Browser*/) throws Exception {
		driver = new ChromeDriver();
		/*if(Browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}*/
		String URL = pUtil.readData("url");
		driver.get(URL);
		Sdriver = driver;
		sUtil.maximizeWindow(driver);
		sUtil.implicitwait(driver);
		System.out.println("====Browser launching successful====");
	}
	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws Exception {
		String USERNAME = pUtil.readData("username");
		String PASSWORD = pUtil.readData("password");
		LogInPage lp = new LogInPage(driver);
		lp.logIntoApp(USERNAME, PASSWORD);
		System.out.println("====Log into app successful====");
	}
	@AfterMethod(alwaysRun = true)
	public void signOut() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		WebElement moveToElement = hp.getAdminstrator();
		sUtil.mouseHover(driver, moveToElement);
		hp.signOut();
		System.out.println("====Sign out from app successful====");
	}
	@AfterClass(alwaysRun = true)
	public void closureBrowser() {
		driver.quit();
		System.out.println("====Clousure of browser successful====");
	}
	@AfterSuite(alwaysRun = true)
	public void DBclousure() {
		System.out.println("====DB clousure successful====");
	}

}
