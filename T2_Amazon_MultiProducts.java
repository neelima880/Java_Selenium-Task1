package Task_1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T2_Amazon_MultiProducts {

	public static void main(String[] args) throws IOException {
				
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neelima\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		String location = "C:\\Users\\Neelima\\Desktop\\Selenum_testing\\multiproduct.csv";
		Scanner inputfile = new Scanner(Paths.get(location));
		inputfile.useDelimiter(";");
		while (inputfile.hasNext()) {
			String itemList = (String) inputfile.next();
			// System.out.println(itemList);
		
	//	String[] itemList1 = {};
		
		driver.get("https://www.amazon.com/");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		// Converting string array into string arraylist for easy iteration
		List<String> newItem = Arrays.asList(itemList);
		
		  for (int j=0;j<newItem.size();j++) {
		    	WebElement s = driver.findElement(By.cssSelector(T2_amazon_mpc.searchbartab));
		    	//System.out.println(newItem.size());
		    	s.sendKeys(newItem.get(j)+"\n");	
		  try {	    		
		    	String path = "//span[contains(text()"+ "," + "'" +newItem.get(j) + "')]";
		    	
		    	driver.findElement(By.xpath(path)).click();
		    	String pathLink = "//span[contains(text()"+ "," + "'" +newItem.get(j) + "')]" +"/parent::a";
		    	String a = driver.findElement(By.xpath(pathLink)).getAttribute("href");
		    	driver.navigate().to(a);
		    	Select sn = new Select(driver.findElement(By.id("quantity")));
		 		 sn.selectByValue("1");
		 		 	 		 
		 		 driver.findElement(By.cssSelector(T2_amazon_mpc.toCart)).click();
		 		 
		 		//Alert pop = driver.switchTo().alert();
		 		 
		 		
		 		 System.out.println(newItem.get(j)+" is now added to cart");
		 		 driver.navigate().to("https://www.amazon.com/");
		    	}
		 catch (Exception e) {
		    		System.out.println("no such element: Unable to find the product");
		    		driver.navigate().to("https://www.amazon.com/");
		    	}	
		    } 
	  }
}
}
