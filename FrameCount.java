package week4.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("http://leafground.com/pages/frame.html");
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		 File dst = new File("./snaps/seat.png");
		 FileUtils.copyFile(src1, dst);
		 int count=0;
		 List <WebElement> frameList= driver.findElementsByTagName("iframe");
		 for (int i=0;i<frameList.size();i++)
		 {
			 count =count+1;
		 }
		 System.out.println("Count of Frame:"+ count);
		 

	}

}
