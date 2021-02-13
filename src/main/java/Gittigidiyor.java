import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Seda Eryilmaz
public class Gittigidiyor {
	public static JavascriptExecutor js;

	public static void main(String[] args) {
		
		WebDriver driver = driver();

		openPage(driver);

		login(driver);

		search(driver);

		goPage2(driver);

		selectProduct(driver);

		addToBasket(driver);

		emptyBasket(driver);

		endProcess(driver);

	}

	public static WebDriver driver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static String openPage(WebDriver driver) {
		// Open the main page
		driver.get("https://www.gittigidiyor.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public static String login(WebDriver driver) {
		// Login link
		driver.findElement(By.cssSelector("div.gekhq4-5:nth-child(1) > div:nth-child(1) > div:nth-child(2)")).click();
		// driver.findElement(By.linkText("Giriþ Yap")).click();
		driver.get(driver.getCurrentUrl() + "uye-girisi");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login user info
		driver.findElement(By.id("L-UserNameField")).sendKeys("ttselenium2021@gmail.com");
		driver.findElement(By.id("L-PasswordField")).sendKeys("Test2021");
		driver.findElement(By.id("gg-login-enter")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.getTitle(); 
	}

	public static String search(WebDriver driver) {
		// Search a word
		driver.findElement(By.name("k")).sendKeys("bilgisayar");
		driver.findElement(By.xpath("//*[@id=\'main-header\']/div[3]/div/div/div/div[2]/form/div/div[2]/button"))
				.click();
		return driver.getTitle(); 
	}

	public static String goPage2(WebDriver driver) {
		// Scroll down
		js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// Page 2
		driver.findElement(By.linkText("2")).click();
		return driver.getTitle();
	}

	public static String selectProduct(WebDriver driver) {
		// select a product
		driver.findElement(By.xpath("//*[@id=\'item-info-block-580994630\']/p")).click();

		// Product prize
		String productPrizeString = driver.findElement(By.xpath("//*[@id=\'sp-price-highPrice\']")).getText();
		return driver.getTitle();
	}

	public static void addToBasket(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// add to basket
		js.executeScript("window.scroll(0,550)");
		driver.findElement(By.id("add-to-basket")).click();
		
		// check the basket amount
		driver.findElement(By.xpath("//*[@id='header_wrapper']/div[4]/div[3]")).click();
		//String basketAmount = driver.findElement(By.className("new-price")).getText();
		
		// add one more product
		driver.findElement(By.cssSelector("select.amount")).sendKeys("2");
	}

	public static void emptyBasket(WebDriver driver) {
		// Delete all products
		driver.findElement(By.cssSelector("div.gg-d-24:nth-child(3) > div:nth-child(1) > a:nth-child(1) > i:nth-child(1)")).click();
		//String emptyMessage= driver.findElement(By.cssSelector("div.gg-d-19:nth-child(2) > h2:nth-child(1)")).getText();
		//System.out.println(emptyMessage);
		//return emptyMessage;
	}

	public static void endProcess(WebDriver driver) {
		// End the process
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
}
