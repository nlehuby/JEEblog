package edu.ecm.blog.selenium;

import javax.annotation.Nullable;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogTest {
	   private WebDriver webDriver;

	   @Before
	   public void init() {
	       // création du pilote firefox
	       webDriver = new FirefoxDriver();
	   }

	   @After
	   public void close() {
	       // fermeture du navigateur
	       webDriver.close();
	   }
	
	
	@Test
	public void home() {
	   // on navigue vers la home
		 webDriver.navigate().to("http://localhost:8080/index");
		
	   // on vérifie le title
	      // on attends le chargement de la page
	      WebElement link = new WebDriverWait(webDriver, 5).until(new ExpectedCondition<WebElement>() {
	         public WebElement apply(@Nullable WebDriver input) {
	            // on doit trouver le lien vers le site
	            return webDriver.findElement(By.partialLinkText("Mon blog"));
	         }
	      });

	      Assert.assertEquals("http://localhost:8080/index", link.getAttribute("href"));
	}


}
