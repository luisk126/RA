package ScreenPlayReto;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RetoAuto 
{
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\dchrome\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.phptravels.net/admin");
	}

	@Test
	public void testIngreso() throws InterruptedException {
		WebElement cajatextusu = driver.findElement(By.name("email"));
		cajatextusu.clear();
		cajatextusu.sendKeys("admin@phptravels.com");

		WebElement cajatextpass = driver.findElement(By.name("password"));
		cajatextpass.clear();
		cajatextpass.sendKeys("demoadmin");

		cajatextpass.submit();
		Thread.sleep(3000);

		// Menu Blog
		WebElement selectpost = driver.findElement(By.xpath("//*[@id=\'social-sidebar-menu\']/li[14]/a"));
		selectpost.click();
		Thread.sleep(3000);

		// Blog Categoria
		WebElement selectpostcat = driver.findElement(By.xpath("//*[@id=\'Blog\']/li[2]/a"));
		selectpostcat.click();
		Thread.sleep(3000);

		// ADD
		WebElement botonadd = driver.findElement(By.xpath("//*[@id=\'content\']/div[2]/div[2]/div[1]/button"));
		botonadd.click();

		Thread.sleep(3000);
		WebElement cajamodalnombre = driver.findElement(By.name("name"));
		cajamodalnombre.clear();
		cajamodalnombre.sendKeys("Palabras de Paises");

		// Seleccionar
		Thread.sleep(3000);
		Select se = new Select(driver.findElement(By.name("status")));
		se.selectByValue("Yes");

		// Nombre en Vietnam
		Thread.sleep(3000);
		WebElement cajamodalnombrevietnam = driver.findElement(By.name("translated[vi][name]"));
		cajamodalnombrevietnam.clear();
		cajamodalnombrevietnam.sendKeys("Vietnamitas");

		// Nombre en Ruso
		Thread.sleep(3000);
		WebElement cajamodalnombreruso = driver.findElement(By.name("translated[ru][name]"));
		cajamodalnombreruso.clear();
		cajamodalnombreruso.sendKeys("Dimitri");

		// Nombre en Arabe
		Thread.sleep(3000);
		WebElement cajamodalnombrearabe = driver.findElement(By.name("translated[ar][name]"));
		cajamodalnombrearabe.clear();
		cajamodalnombrearabe.sendKeys("Ahdul");

		// Nombre en Farsi
		Thread.sleep(3000);
		WebElement cajamodalnombrefarsi = driver.findElement(By.name("translated[fa][name]"));
		cajamodalnombrefarsi.clear();
		cajamodalnombrefarsi.sendKeys("Farias");

		// Nombre en Turkia
		Thread.sleep(3000);
		WebElement cajamodalnombreturkia = driver.findElement(By.name("translated[tr][name]"));
		cajamodalnombreturkia.clear();
		cajamodalnombreturkia.sendKeys("Kaleh");

		// Nombre en Francia
		Thread.sleep(3000);
		WebElement cajamodalnombrefrancia = driver.findElement(By.name("translated[fr][name]"));
		cajamodalnombrefrancia.clear();
		cajamodalnombrefrancia.sendKeys("Anthuan");

		// Nombre en España
		Thread.sleep(3000);
		WebElement cajamodalnombreespaña = driver.findElement(By.name("translated[es][name]"));
		cajamodalnombreespaña.clear();
		cajamodalnombreespaña.sendKeys("Villareal");

		// Nombre en Alemania
		Thread.sleep(3000);
		WebElement cajamodalnombrealemania = driver.findElement(By.name("translated[de][name]"));
		cajamodalnombrealemania.clear();
		cajamodalnombrealemania.sendKeys("Panzer");

		// Add
		Thread.sleep(3000);
		WebElement botonmodaladd = driver
				.findElement(By.xpath("//*[@id=\"ADD_BLOG_CAT\"]/div[2]/div/form/div[3]/button[2]"));
		botonmodaladd.click();

		// Menu Blog
		WebElement selectblog = driver.findElement(By.xpath("//*[@id=\'social-sidebar-menu\']/li[14]/a"));
		selectblog.click();
		Thread.sleep(3000);

		// Blog
		WebElement selectblog1 = driver.findElement(By.xpath("//*[@id=\'Blog\']/li[1]/a"));
		selectblog1.click();
		Thread.sleep(3000);

		// ADD
		WebElement botonaddblog = driver.findElement(By.xpath("//*[@id=\'content\']/div[2]/form/button"));
		botonaddblog.click();

		Thread.sleep(3000);
		Select selcat = new Select(driver.findElement(By.name("category")));

		String val = "";

		List<WebElement> op = selcat.getOptions();
		int size = op.size();
		for (int i = 0; i < size; i++) {

			// obtiene el value
			String options = op.get(i).getAttribute("value");
			String optionstxt = op.get(i).getText();
			// obtiene el text
			System.out.println(options + optionstxt);

			if (optionstxt.equals(" Palabras de Paises ")) {
				System.out.println("Se encuentra registrada");
				val = options;
			} else {
				System.out.println("No se encuentra registrada");
			}
		}

		// Selecciona el texto asignado anteriormente
		selcat.selectByValue(val);

		Thread.sleep(10000);
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
