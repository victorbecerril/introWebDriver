package intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FacebookTest extends ParentTest{

	public static void main(String[] args) {
		setUp();
		testFriendSearch("Jorge Alvarado");
		tearDown();

	}

	private static void testFriendSearch(String friendName) {
		loginToFacebook("joecool2546@mail.com", "abcde012@F");
		searchFriend(friendName);
		addFriend(friendName, "Listens to");
		
	}

	private static void addFriend(String friendName, String differentiator) {
//		WebElement friendLink = driver.findElement(By.linkText(friendName));
//		
//		friendLink.click();
//
//		WebElement addFriendButton = driver.findElement(By.xpath("//button[contains(@class, 'FriendRequestAdd')]"));
//		
//		addFriendButton.click();
		
		//Crear un webelement que es el contenedor correcto.
		WebElement correctContainer = null;
		
		//buscar una lista de contenedores
		List<WebElement> containerList = driver.findElements(By.className("_2yer"));
		//barrer esa lista de contenedores, buscando la persona correcta.
		for (WebElement container:containerList)
		{
			if(container.getText().contains(differentiator)) {
				correctContainer = container;
				break;
			}
		}
		//dentro del contenedor de la persona correcta, buscar el boton de 'agregar a amigos'
		WebElement correctButton = correctContainer.findElement(By.xpath(".//button[contains(@class, 'FriendRequestAdd')]"));
		//das click al boton que encontraste arriba.
		correctButton.click();
	}

	private static void searchFriend(String friendName) {
		WebElement searchBox = driver.findElement(By.name("q"));		
		searchBox.clear();
		searchBox.sendKeys(friendName);
		WebElement searchButton = driver.findElement(By.xpath("//*[@data-testid=\"facebar_search_button\"]"));
		searchButton.click();
		
	}

	private static void loginToFacebook(String emailInput, String passwordInput) {
		WebElement emailField = driver.findElement(By.name("email"));
		WebElement passwordField = driver.findElement(By.name("pass"));
		WebElement logInButton = driver.findElement(By.xpath("//*[@data-testid=\"royal_login_button\"]"));
		
		emailField.clear();
		emailField.sendKeys(emailInput);
		passwordField.clear();
		passwordField.sendKeys(passwordInput);
		logInButton.click();		
	}

}
