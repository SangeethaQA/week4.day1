package week4.day1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  	WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
			driver.manage().window().maximize() ;
			driver.switchTo().frame("frame1");
			driver.findElementByXPath("//input[@type='text']").sendKeys("Testing Frame");
			driver.switchTo().frame("frame3");
			driver.findElementByXPath("//input[@type='checkbox']").click();
			driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frame2");
			driver.findElementById("animals").sendKeys("Baby Cat");
			
			
		

	}

}
