import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Differentframes {
	public static void main(String []args) {
		//set system property for the chrome browser
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\FELCY\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				// launch Browser
				WebDriver driver = new ChromeDriver();
				
				//Navigating the URL
				driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");
				
				//Using ImplicitlyWait for page to wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//maximize window
				driver.manage().window().maximize();
				
				//switch to top frame
				WebElement top = driver.findElement(By.xpath("//frame[@name='frame-top']"));
				
				driver.switchTo().frame(top);
				
				// Verifying three frames on the page
				List<WebElement> frame = driver.findElements(By.tagName("frame"));
				String Size = String.valueOf(frame.size());
				if (Size.equals("3")) 
				{
					System.out.println("Three Frames Present");
				} else {
					System.out.println("Less than 3 frames are present");
				}

				WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
				
				// Switching to left frame
				driver.switchTo().frame(leftFrame);

				// Locating the text 
				WebElement text = driver.findElement(By.tagName("body"));
				String left = text.getText();

				// Verifying left frame 
				
				if (left.equals("LEFT"))
				{
					System.out.println("Left frame has: " + left);
				} 
				else 
				{
					System.out.println("Left frame have no text");
				}

				// Switching back to the top frame
				driver.switchTo().parentFrame();

				WebElement midframe = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
				
				// Switching to middle frame
				driver.switchTo().frame(midframe);

				// Locating the text 
				WebElement text1 = driver.findElement(By.tagName("body"));
				String middleText = text1.getText();

				// Verifying that the middle frame 
				
				if (middleText.equals("MIDDLE")) 
				{
					System.out.println("Middle frame has: " + middleText);
				} 
				else 
				{
					System.out.println("Middle frame have no text");
				}

				// Switching back to the top frame
				driver.switchTo().parentFrame();
				

				WebElement rightframe = driver.findElement(By.xpath("//frame[@name='frame-right']"));
				
				// Switching to right frame
				driver.switchTo().frame(rightframe);

				// Locating the text 
				WebElement text2 = driver.findElement(By.tagName("body"));
				String rightText = text2.getText();

				// Verifying that the right frame 
				
				if (rightText.equals("RIGHT")) 
				{
					System.out.println("Right frame has: " + rightText);
				} 
				else 
				{
					System.out.println("Right frame have no text");
				}

				// Switching back to the top frame
				driver.switchTo().parentFrame();
				driver.switchTo().defaultContent();
				
                WebElement bottomframe = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
				
				// Switching to bottom frame
				driver.switchTo().frame(bottomframe);

				// Locating the text 
				WebElement text3 = driver.findElement(By.tagName("body"));
				String bottomText = text3.getText();

				// Verifying that the bottom frame 
				
				if (bottomText.equals("BOTTOM")) 
				{
					System.out.println("Bottom frame has: " + bottomText);
				} 
				else 
				{
					System.out.println("Bottom frame have no text");
				}

		       
				
				//Closing the driver
				// driver.close();
				
	}

}
