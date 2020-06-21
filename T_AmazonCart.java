
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class T_AmazonCart {

	public static void main(String[] args) {
				
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neelima\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Actions act = new Actions(driver);
		
						
		driver.get("https://www.amazon.com/");
		driver.findElement(By.cssSelector(T_amazonCartConstant.searchbartab)).sendKeys("tennis ball"+"\n");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
		System.out.println(driver.findElement(By.xpath(T_amazonCartConstant.dept)).getText());
		 driver.findElement(By.xpath(T_amazonCartConstant.sportdept)).click();
		 
		 WebElement branditem = driver.findElement(By.xpath(T_amazonCartConstant.brand));
		 act.moveToElement(branditem).perform();
		 branditem.click();
		 
		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 List <WebElement> pinkball = driver.findElements(By.xpath(T_amazonCartConstant.allwilsonball));
		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 		/* for (WebElement ele: pinkball) {
		 			 System.out.println(ele.getText());
		 			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 			String ballComp = "Wilson 20/20 Racquetball (3 Ball Can), Pink";
		 			 if (ele.getText().equals(ballComp)){
		 				 System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Wilson')]/parent::a")).getAttribute("href"));
		 			 String finalLink = driver.findElement(By.xpath("//span[contains(text(),'Wilson')]/parent::a")).getAttribute("href");
		 			 System.out.println(finalLink);
		 			 driver.navigate().to(finalLink);
		 			 }
		 		 }*/
		 
		 Iterator <WebElement> ballList = pinkball.iterator();
		 while (ballList.hasNext()) {
			 WebElement r = ballList.next();
			 System.out.println(r.getText());
			 String ballComp = "Wilson 20/20 Racquetball (3 Ball Can), Pink";
			 if (r.getText().equals(ballComp)) {
				 System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Wilson')]/parent::a[1]")).getAttribute("href"));
				 String f = driver.findElement(By.xpath("//span[contains(text(),'Wilson')]/parent::a[1]")).getAttribute("href");
				driver.navigate().to(f);
				break;
				 
			 }
			 
		 }
		 		 
		 		 WebElement ball = driver.findElement(By.xpath(T_amazonCartConstant.pinkbtennisball));
		 		 act.moveToElement(ball).perform();
		 		 ball.click();
		 		 
		 		 Select s = new Select(driver.findElement(By.id("quantity")));
		 		 s.selectByValue("2");
		 		 	 		 
		 		 driver.findElement(By.cssSelector(T_amazonCartConstant.toCart)).click();
		 		 
		 		 
		 		 
		 		 
		 		 
	
	
	
	
	
	
	
	
	
	
	}
	
	
}
		