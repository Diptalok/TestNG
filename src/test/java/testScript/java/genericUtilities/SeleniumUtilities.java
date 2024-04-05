package testScript.java.genericUtilities;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtilities {
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void mouseHover(WebDriver driver,WebElement moveToElement) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(moveToElement).perform();
		Thread.sleep(1000);
	}
	public void acceptAlert(WebDriver driver) throws InterruptedException {
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}
	public void closeBrowser(WebDriver driver) throws InterruptedException {
		driver.close();
		Thread.sleep(2000);
	}
	public void validation(String OrganizationName, String OrgName) {
		if(OrgName.contains(OrganizationName)) {
			System.out.println("=====Test case is passed====");
		}
		else {
			System.out.println("=====Test case is failed====");
		}
	}
	public void navigateBackward(WebDriver driver) {
		for(int i=0;i<2;i++) {
			driver.navigate().back();
		}
	
	}
	public void handleDropdown(WebDriver driver,WebElement element,String text) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
		
	}
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,4000)");
	}
	public String takeScreenshot(WebDriver driver, String page) throws Exception{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(".\\Screenshots\\"+page+".png");
		FileUtils.copyFile(source, destination);
		return destination.getAbsolutePath();
	}
	public void switchWindow(WebDriver driver) {
		Set<String> windowIDs = driver.getWindowHandles();
		for (String window : windowIDs) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title=="Compose Mail") {
				break;
			}
		}
	}
	public void switchMainWindow(WebDriver driver) {
		Set<String> windowIDs = driver.getWindowHandles();
		for (String window : windowIDs) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title=="Adminstrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM") {
				break;
			}
		}
	}

}
