package webTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   	  System.setProperty("webdriver.edge.driver", "F:\\Homeworks\\SoftwareTesting\\msedgedriver.exe");
   	// active the server
       WebDriver driver = new EdgeDriver();
       // jump to the link
       driver.get("http://47.108.210.119:8080/onlineMusic/login.html");
       WebElement element8= driver.findElement(By.xpath("//*[@id=\"user\"]"));
       // input 
       element8.sendKeys("7237898234687");
       WebElement element9 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
       element9.sendKeys("1231213349874");
       WebElement element10= driver.findElement(By.xpath("//*[@id=\"submit\"]"));
       // submit
       element10.click();
       try 
       {
			Thread.sleep(4000);
		} 
       catch (InterruptedException e) 
       {
			e.printStackTrace();
		}
        System.out.println(driver.getTitle());
       System.out.println("test sucess");
       // close
       driver.close();
	}

}



