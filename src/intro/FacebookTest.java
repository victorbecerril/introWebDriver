package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FacebookTest extends ParentTest{

	public static void main(String[] args) {
		setUp();
		testFriendSearch("Raul Reza");
		tearDown();

	}

	private static void testFriendSearch(String friendName) {
		loginToFacebook("joecool2546@mail.com", "abcde012@F");
		searchFriend(friendName);
		addFriend(friendName);
		
	}

	private static void addFriend(String friendName) {
		WebElement friendLink = driver.findElement(By.linkText(friendName));
		
		friendLink.click();

		WebElement addFriendButton = driver.findElement(By.xpath("//button[contains(@class, 'FriendRequestAdd')]"));
		
		addFriendButton.click();
		
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
		WebElement logInButton = driver.findElement(By.id("u_0_2"));
		
		emailField.clear();
		emailField.sendKeys(emailInput);
		passwordField.clear();
		passwordField.sendKeys(passwordInput);
		logInButton.click();		
	}

}
