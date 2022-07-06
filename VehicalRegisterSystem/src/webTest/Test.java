package webTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Test {

	public static void main(String[] args) {
		 // location
    	System.setProperty("webdriver.edge.driver", "F:\\Homeworks\\SoftwareTesting\\msedgedriver.exe");
    	// active the server
        WebDriver driver = new EdgeDriver();
        // jump to the link
        driver.get("http://47.108.210.119:8080/onlineMusic/login.html");
        // using xPath to locate the elements
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div[4]/a"));
        // input 
        element1.sendKeys("diego242422");
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        element2.sendKeys("13533hanson");
        WebElement element3= driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        // submit
        element3.click();
        // get the title when we jump
        System.out.println(driver.getTitle());
        System.out.println("test success");
        
        //pause
        try 
        {
			Thread.sleep(4000);
		} 
        catch (InterruptedException e) 
        {
			e.printStackTrace();
		}
        // close
        driver.close();
	}

}
