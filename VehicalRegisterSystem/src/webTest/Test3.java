package webTest;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//保证List使用正确
public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // location
    	System.setProperty("webdriver.edge.driver", "F:\\Homeworks\\SoftwareTesting\\msedgedriver.exe");
    	// active the server
        WebDriver driver = new EdgeDriver();
        // jump to the link
        driver.get("http://47.108.210.119:8080/onlineMusic/login.html");
        // using xPath to locate the elements
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div[4]/a"));
        element1.click();
        try 
        {
			Thread.sleep(1000);
		} 
        catch (InterruptedException e) 
        {
			e.printStackTrace();
		}
        // input 
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        element2.sendKeys("123");
        WebElement element3= driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        // submit
        try 
        {
			Thread.sleep(1000);
		} 
        catch (InterruptedException e) 
        {
			e.printStackTrace();
		}
        WebElement element4 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        element4.sendKeys("123");
        try 
        {
			Thread.sleep(1000);
		} 
        catch (InterruptedException e) 
        {
			e.printStackTrace();
		}
        WebElement element5 = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        element5.sendKeys("123");
        try 
        {
			Thread.sleep(1000);
		} 
        catch (InterruptedException e) 
        {
			e.printStackTrace();
		}
        WebElement element6 = driver.findElement(By.xpath("//*[@id=\"gender\"]"));
        element6.sendKeys("123");
        try 
        {
			Thread.sleep(1000);
		} 
        catch (InterruptedException e) 
        {
			e.printStackTrace();
		}
        WebElement element7 = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        element7.sendKeys("123");
        try 
        {
			Thread.sleep(1000);
		} 
        catch (InterruptedException e) 
        {
			e.printStackTrace();
		}
        // get the title when we jump
        element3.click();
        System.out.println(driver.getTitle());
        System.out.println("test sucess");
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
