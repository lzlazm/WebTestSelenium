import java.util.concurrent.TimeUnit;

import javax.servlet.annotation.HandlesTypes;
import javax.swing.Spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle.Control;
import java.util.concurrent.TimeUnit;

import org.apache.xpath.operations.Neg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.MaximizeWindow;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

import org.openqa.selenium.JavascriptExecutor;

import net.bytebuddy.implementation.bind.DeclaringTypeResolver;

public class Webtt {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LZL\\Desktop\\Undergraduate_Research\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.get("https://www.google.com");
		
		    
		driver.manage().window().maximize();
		Actions actionOpenLinkInNewTab = new Actions(driver); // ???

	String titleWeb = driver.getTitle();
	System.out.println(titleWeb);
	
	//Use Baidu search engine to search Peking University
	driver.get("https://www.baidu.com/");
	WebElement webBaidu = driver.findElement(By.id("kw"));
	webBaidu.sendKeys("北京大学");
	WebElement webButton = driver.findElement(By.id("su"));
	webButton.click();
	 
	String current_handle = driver.getWindowHandle(); //Get current handle
System.out.println(current_handle);
	
	// Wait 5 sec
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//Open new tab,control + T doesn't work for Chrome because of issues of ChromeDriver itself.
	 ((JavascriptExecutor) driver).executeScript("window.open('https://www.baidu.com','_blank');");

	 for(String myhandles: driver.getWindowHandles())
	 {
	 	if(myhandles.equals(current_handle))
	 	{
	 		continue;
	 	}
	 	 driver.switchTo().window(myhandles);	 	 
	 	}
	 String aa = driver.getWindowHandle();
		System.out.println(aa);
		WebElement ser = driver.findElement(By.id("kw"));
		ser.sendKeys("aaa");
		ser.submit();
	}
	
}
