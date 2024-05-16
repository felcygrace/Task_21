import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {
	public void switchToWindows() {
		//set system property for the chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\FELCY\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// launch Browser
		WebDriver driver = new ChromeDriver();
		//Navigating the URL
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		//Using ImplicitlyWait for page to wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//maximize window
		driver.manage().window().maximize();
		//click on the link
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		//Switching to new window and converting the set to list
		Set<String> window = driver.getWindowHandles();
		List<String> list = new ArrayList<>(window);
        
		//Using get(index)
		driver.switchTo().window(list.get(1));
		
		//verify the text
		String str = driver.findElement(By.tagName("h3")).getText();
		
		if(str.equals("New Window")) {
			System.out.println("Text is present in new window");
		}
		else {
			System.out.println("Text is not present in new window");
		}
		
		//Closing the browser
		driver.close();
		//switching to parent window
		driver.switchTo().window(list.get(0));
		
		//Using ImplicitlyWait for page to wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentstr = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
		if(parentstr.equals("Opening a new window")) {
			System.out.println("Successfully Switched back to parent window");
		}
		else {
			System.out.println("Not switched back to parent window");
		}
		//quiting Browser
		driver.quit();
		
	}
	
	
	
	public static void main(String []args) {
		Windows windows = new Windows();
		windows.switchToWindows();
	}

}
