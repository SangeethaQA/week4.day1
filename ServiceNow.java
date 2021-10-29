package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-Notifications");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://dev69731.service-now.com/navpage.do");
		driver.manage().window().maximize() ;
		Thread.sleep(2000);
		//Login
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("Geetha@001");
		driver.findElementById("sysverb_login").click();
		driver.switchTo().defaultContent();
		//Search incident and All
		driver.findElementById("filter").sendKeys("incident");
		driver.findElementByXPath("(//div[contains(text(),'All')])[2]").click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//button[text()='New']").click();
		
		
		//incident creation 
		driver.findElementById("lookup.incident.caller_id").click();
		Set <String> handleWindow= driver.getWindowHandles();
		List <String> winHandle= new ArrayList <String>(handleWindow);
		driver.switchTo().window(winHandle.get(1));
		driver.findElementByXPath("//a[text()='survey user']").click();
		driver.switchTo().window(winHandle.get(0));
		driver.switchTo().frame("gsft_main");
		//driver.findElementById("sys_display.incident.caller_id").sendKeys("System Administrator");
		driver.findElementById("incident.short_description").sendKeys("Automation Testing");
		String value=driver.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
		System.out.println("value is :"+value);
		driver.findElementById("sysverb_insert").click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='New']")));
		
		Select sl = new Select (driver.findElementByXPath("//div[@class='input-group']//select"));
		sl.selectByValue("number");
		driver.findElementByXPath("//div[@class='input-group']//input[@placeholder='Search']").sendKeys(value,Keys.ENTER);
	
		String text1= driver.findElementByXPath("//a[@class='linked formlink']").getText();
		if (text1.equals(value))
				System.out.println("Verified the incident");
		else
			System.out.println("Incident is incorrect");
		
		
		
		
		
		

	}

}
