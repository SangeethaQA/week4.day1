package week4.day1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 2. Enter UserName and Password Using Id Locator
		 * 3. Click on Login Button using Class Locator
		 * 4. Click on CRM/SFA Link
		 * 5. Click on contacts Button
		 * 6. Click on Merge Contacts using Xpath Locator
 			7. Click on Widget of From Contact
		 * 8. Click on First Resulting Contact
		 * 9. Click on Widget of To Contact
		 * 10. Click on Second Resulting Contact
		 * 11. Click on Merge button using Xpath Locator
		 * 12. Accept the Alert
		 * 13. Verify the title of the page*/
		
		  WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize() ;
		
		WebElement eleuserName = driver.findElement(By.id("username"));
		eleuserName.sendKeys("Demosalesmanager");
		
		WebElement elePassword = driver.findElement(By.id("password"));
		elePassword.sendKeys("crmsfa");
		
		
		
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElementByLinkText("Contacts").click();
		
		driver.findElementByXPath("//a[contains(text(),'Merge Contacts')]").click();
		
		driver.findElementByXPath("//table [@id='widget_ComboBox_partyIdFrom']/following-sibling::a").click();
		
		Set<String>s=driver.getWindowHandles();
		List <String> winList = new ArrayList<String>(s);
		driver.switchTo().window(winList.get(1));
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a").click();
		
		driver.switchTo().window(winList.get(0));
		
		driver.findElementByXPath("//table [@id='widget_ComboBox_partyIdTo']/following-sibling::a").click();
		Set<String>s1=driver.getWindowHandles();
		List <String> winList1 = new ArrayList<String>(s1);
		driver.switchTo().window(winList1.get(1));
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]").click();
		
		driver.switchTo().window(winList1.get(0));
		driver.findElementByXPath("//a[text()='Merge']").click();
		
		Alert al =driver.switchTo().alert();
		al.accept();
		
		System.out.println("Page title is : " + driver.getTitle());


	}

}
