package classExercise;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImdbChrome {
	
	static WebDriver driver;
	static String imdbUrl = "http://imdb.com";
	static String movieName = "It";
	static String movieYear = "2017";
	private static String movieDirector = "Andy Muschietti";
	private static String movieWriter1 = "Chase Palmer";
	private static String movieWriter2 = "Cary Joji Fukunaga";
	
	public static void main(String[] args) {
		openImdb();
		searchMovie(movieName);
		validateMovieLink(movieName, movieYear);
		clickMovieLink(movieName, movieYear);
		//clickMovieLink(movieName);
		validateMovieYear(movieYear);
		validateMovieDirector(movieDirector);
		validateWriter(movieWriter1);
		validateWriter(movieWriter2);
		closeBrowser();
	}
	
	private static void validateWriter(String movieWriter) {
		WebElement correctContainer = null;
		List<WebElement> containerList = driver.findElements(By.className("credit_summary_item"));
		for(WebElement currentContainer : containerList) {
			if(currentContainer.getText().contains("Writers")) {
				correctContainer = currentContainer;
				break;
			}
		}
		String writerText = correctContainer.getText();
		if(writerText.contains(movieWriter)) {
			System.out.println("Sí contiene el texto: " + movieWriter);
		}else {
			System.exit(-1);
		}
	}

	private static void clickMovieLink(String movieName2, String movieYear2) {
		WebElement correctMovie = null;
		List<WebElement> movieLists = driver.findElements(By.className("result_text"));
		for(WebElement movieRow : movieLists) {
			System.out.println(movieRow.getText());
			if(movieRow.getText().contains(movieYear)) {
				correctMovie = movieRow;
				break;
			}
		}
		//correctMovie.click();
		WebElement correctLink = correctMovie.findElement(By.linkText(movieName));
		correctLink.click();
		
		
	}

	private static void findAllMovieLinks(String movieName2) {
		List<WebElement> linkList = driver.findElements(By.className("result_text"));
		for(WebElement elem: linkList) {
			System.out.println(elem.getText());
		}
		
		
	}

	private static void validateMovieDirector(String movieDirector) {
		WebElement director = driver.findElement(By.className("credit_summary_item"));
		String text = director.getAttribute("textContent");
		if(text.contains(movieDirector)) {
			System.out.println("Director encontrado");
		} else {
			System.exit(-1);
		}
	}

	private static void validateMovieYear(String movieYear) {
		WebElement movieYearElem = driver.findElement(By.id("titleYear"));
		String movieYearTxt = movieYearElem.getText();
		if(movieYearTxt.contains(movieYear)) {
			System.out.println("Movie year: " + movieYear);
		} else {
			System.exit(-1);
		}
		
	}

	private static void validateMovieLink(String movieName, String movieYear) {
		WebElement correctMovie = null;
		List<WebElement> movieLists = driver.findElements(By.className("result_text"));
		for(WebElement movieRow : movieLists) {
			System.out.println(movieRow.getText());
			if(movieRow.getText().contains(movieYear)) {
				correctMovie = movieRow;
				break;
			}
		}
		
		if(correctMovie != null) {
			System.out.println("Movie: " + movieName + " from year: " + movieYear + " was found.") ;
		} else {
			System.exit(-1);
		}
	}

	private static void closeBrowser() {
		driver.quit();
		
	}
	private static void clickMovieLink(String movieName) {
		// busco la liga de movieName
		WebElement ligaMovie = driver.findElement(By.linkText(movieName));
		//click a la liga de movieName
		ligaMovie.click();
	}
	private static void searchMovie(String movieName) {
		//busco el campo de texto
		WebElement campoBusqueda = driver.findElement(By.id("navbar-query"));
		//busco el boton de busqueda.
		WebElement botonBusqueda = driver.findElement(By.id("navbar-submit-button"));
		//introduzco movieName en el campo de texto
		campoBusqueda.clear();
		campoBusqueda.sendKeys(movieName);
		//doy click al boton de busqueda.
		botonBusqueda.click();
		
	}
	private static void openImdb() {
		//abro la sesion de chrome
		driver = new ChromeDriver();
		//navego a imdb.com
		driver.get(imdbUrl);
	}

}
