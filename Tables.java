package Task2_week;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {
	
	public String tableInfo(WebElement driver) {
		String itemno = "";
		for (int n=0;n<7;n++) {
			String itemsList = driver.findElements(By.cssSelector("td[class='Py(10px) Pstart(10px)']")).get(n).getText() + ";";
			 itemno = itemno.concat(itemsList);
		}
		return itemno;
	}
	
	public void fileRead() throws IOException {
		 Scanner toRead = new Scanner(Paths.get("C:\\Users\\Neelima\\Desktop\\Selenum_testing\\csv.csv"));
	      toRead.useDelimiter("\t");
	      while (toRead.hasNext()) {
	    	  String fromcsv = toRead.next();
	    	  System.out.println(fromcsv);
	      }
	}
	    	  
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neelima\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Tables t = new Tables();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		driver.get("https://finance.yahoo.com/quote/AAPL/history/");
		
		WebElement table = driver.findElement(By.cssSelector("div[class='Pb(10px) Ovx(a) W(100%)']"));
		String listvalue = t.tableInfo(table);
				
		String items = "";
		int count = table.findElements(By.cssSelector("tr[class='BdT Bdc($seperatorColor) Ta(end) Fz(s) Whs(nw)']")).size();
		for (int i=0;i<count;i++) {
			table = driver.findElement(By.cssSelector("div[class='Pb(10px) Ovx(a) W(100%)']"));
			items = items.concat(table.findElements(By.cssSelector("td[class='Py(10px) Ta(start) Pend(10px)']")).get(i).getText() + ";" + listvalue + "\n");
			FileWriter ele = new FileWriter(new File("C:\\Users\\Neelima\\Desktop\\Selenum_testing\\csvread.csv"));
			ele.write(items);
			ele.close();
		
		}   
	
	}

}
