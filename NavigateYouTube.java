import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateYouTube {

	public static void main(String[] args) {
		
		//open browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://youtube.com");
		
		//enters text into the search bar and clicks search
		WebElement searchBar = driver.findElement(By.cssSelector("input[id*=search]"));
		searchBar.click();
		searchBar.sendKeys("end of the beginning djo");
		
		WebElement searchButton = driver.findElement(By.cssSelector("button[aria-label*=Search]"));
		searchButton.click();
		
		//wait until the filters option is visible to confirm search is completed before finding and selecting a video
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement filters = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id*=filter-menu]")));
		
		System.out.println(filters.isDisplayed());
		
		//create a list of video links
		List<WebElement> videoLinks = driver.findElements(By.cssSelector("a[id*=video-title]"));
		WebElement firstVideoResult = null;
		
		//iterates through each video link until it finds the first visible link
		for (WebElement video : videoLinks) {
			if (video.isDisplayed()) {
				System.out.println("Video title is " + video.getAttribute("innerText"));
				firstVideoResult = video;
				break;
			}
		}
		
		//clicks first result
		firstVideoResult.click();
	}
}
		