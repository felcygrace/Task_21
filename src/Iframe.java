import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
	public void switchToIframe() {
		//set system property for the chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\FELCY\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// launch Browser
		WebDriver driver = new ChromeDriver();
		//Navigating the URL
		driver.navigate().to("https://the-internet.herokuapp.com/iframe");
		//Using ImplicitlyWait for page to wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//maximize window
		driver.manage().window().maximize();
		//switching frame using xpath
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframe);
		//type Hello people
		WebElement text = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
		text.clear();
		text.sendKeys("Hello People");
		//print in console
		WebElement printtext = driver.findElement(By.tagName("p"));
		System.out.println("Written Text: " + printtext.getText());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Closing the browser
		driver.close();
		
	}
	
	
	
	public static void main(String []args) {
		Iframe iframe = new Iframe();
		iframe.switchToIframe();
	}

}
