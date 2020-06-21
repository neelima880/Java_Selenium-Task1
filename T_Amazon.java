import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class T_Amazon {
			
	
	public static void main(String[] args) {
		// TO click on all links and validate at least string in each page of(Get to know Us)
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neelima\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);

		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement item = driver.findElement(By.xpath(T_amazonconstant.Gettoknowustext));
		System.out.println(item.getText());
		act.moveToElement(item).perform();

		WebElement firstitem = driver.findElement(By.xpath(T_amazonconstant.Careers));
		String a = driver.getCurrentUrl();
		firstitem.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// issue with search and location tabs

		WebElement loca = driver.findElement(By.xpath(T_amazonconstant.Viewopenjobs));
		act.moveToElement(loca).perform();
		loca.click();

		driver.navigate().to(a);

		WebElement blogitem = driver.findElement(By.xpath(T_amazonconstant.Blog));
		act.moveToElement(blogitem).perform();
		blogitem.click();

		WebElement blogsearch = driver.findElement(By.cssSelector(T_amazonconstant.Bloghomepagesearch));
		blogsearch.sendKeys("health health and safety" + "\n");      //health -2
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.navigate().to(a);

		WebElement amazon = driver.findElement(By.xpath(T_amazonconstant.Aboutamazon));
		act.moveToElement(amazon).perform();
		amazon.click();

		driver.findElement(By.cssSelector(T_amazonconstant.menudot)).click();
		driver.findElement(By.xpath(T_amazonconstant.Spheres)).click(); //opens new window
		Set <String> newtab= driver.getWindowHandles();
		Iterator <String> tabid=newtab.iterator();
		 String parentid = tabid.next();
		 String childid = tabid.next();
		 driver.switchTo().window(childid);
		 driver.close();
		 
		 driver.switchTo().window(parentid);
		 

		driver.navigate().back();

		WebElement press = driver.findElement(By.xpath(T_amazonconstant.Press));
		act.moveToElement(press).perform();
		press.click();

		WebElement language = driver.findElement(By.cssSelector(T_amazonconstant.Language));
		language.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//div[@class='module-languages_dropdown_list list--reset']/ul/li[4]/a[1]")).click();
		// driver.findElement(By.xpath(T_amazonconstant.India)).click(); // problem 

		driver.navigate().to(a);

		WebElement Investor = driver.findElement(By.xpath(T_amazonconstant.investor));
		act.moveToElement(Investor).perform();
		Investor.click();

		driver.findElement(By.xpath(T_amazonconstant.cont)).click();

		driver.navigate().to(a);

		WebElement Devic = driver.findElement(By.xpath(T_amazonconstant.devicetab));
		act.moveToElement(Devic).perform();
		Devic.click();
		driver.findElement(By.cssSelector(T_amazonconstant.devicsearch)).sendKeys("iphone 11" + "\n");

		driver.navigate().to(a);

		WebElement tours = driver.findElement(By.xpath(T_amazonconstant.tours));
		act.moveToElement(tours).perform();
		tours.click();

		driver.findElement(By.xpath(T_amazonconstant.tourlink)).click();
		driver.quit();

	}

}
