package classExercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookAddFriend {

	static WebDriver driver; 

	public static void main(String[] args) { 

		//configurarNavegador 

		configurarNavegador(); 

		//login 

		logearFacebook("joecool2546@mail.com", "abcde012@F"); 

		//buscar 

		buscarAmigo("nombreAmigo"); 

		//agregar 

		agregarAmigo("nombreAmigo"); 
		
		destruirConfiguracion();

	} 


	private static void destruirConfiguracion() {
		driver.close();
		
	}


	private static void configurarNavegador() {  
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);  //driver de chrome

		//System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.get("http://www.facebook.com"); 

	} 

	private static void logearFacebook(String usuario, String password) { 
		WebElement campoUsuario; //id=email
		WebElement campoPassword; //id="pass"
		WebElement botonLogin; //data-testid="royal_login_button"
		
		campoUsuario = driver.findElement(By.id("email"));
		campoPassword = driver.findElement(By.id("pass"));
		botonLogin = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		
		campoUsuario.clear();
		campoUsuario.sendKeys(usuario);
		campoPassword.clear();
		campoPassword.sendKeys(password);
		botonLogin.click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		
	} 

	private static void agregarAmigo(String string) {
		

	}

	private static void buscarAmigo(String string) {

	}


}
