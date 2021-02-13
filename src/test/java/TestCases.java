import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

// Seda Eryilmaz
public class TestCases {

	public static Gittigidiyor gittigidiyor;
	public static WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		gittigidiyor = new Gittigidiyor();

		driver = gittigidiyor.driver();

		gittigidiyor.openPage(driver);

		gittigidiyor.login(driver);

		gittigidiyor.search(driver);

		gittigidiyor.goPage2(driver);

		gittigidiyor.selectProduct(driver);

		gittigidiyor.addToBasket(driver);

		gittigidiyor.emptyBasket(driver);

	}

	@Test
	public void canOpenPage() {

		assertEquals("GittiGidiyor - Türkiye'nin Öncü Alýþveriþ Sitesi", gittigidiyor.openPage(driver));
	}
	
	@Test
	public void canLogin() {

		assertEquals("GittiGidiyor - Türkiye'nin Öncü Alýþveriþ Sitesi", gittigidiyor.login(driver));
	}
	
	@Test
	public void canSearch() {

		assertEquals("https://www.gittigidiyor.com/arama/?k=bilgisayar", gittigidiyor.openPage(driver));		
	}
	
	@Test
	public void canGoPage2() {

		assertEquals("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2", gittigidiyor.goPage2(driver));		
	}
	
	@Test
	public void canSelectProduct() {

		assertEquals("https://www.gittigidiyor.com/bilgisayar-tablet/mouse-pad-nano-wireless-kablosuz-mouse-bilgisayar-notebook-faresi_pdp_580994630", gittigidiyor.selectProduct(driver));		
	}
	
	/*@Test
	public void canAddProduct() {

		assertEquals("https://www.gittigidiyor.com/sepetim", gittigidiyor.selectProduct(driver));		
	}
	
	@Test
	public void canEmptyBasket() {

		//assertEquals("Sepetinizde ürün bulunmamaktadýr.", gittigidiyor.emptyBasket(driver));		
	}*/
	
}
