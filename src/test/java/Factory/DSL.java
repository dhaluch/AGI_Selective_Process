package Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DSL {
    private WebDriver navegador;

    public DSL(WebDriver navegador) {
        this.navegador = navegador;
    }


    public void escreve(String CssSelector, String Texto){
        navegador.findElement(By.cssSelector(CssSelector)).sendKeys(Texto);
    }
    public void click(String CssSelector){
        navegador.findElement(By.cssSelector(CssSelector)).click();
    }
    public void clickId(String id){
        navegador.findElement(By.id(id)).click();
    }
    public void AguardarPorId(String id){
        new WebDriverWait(navegador, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }
    public void AguardarCssSelector(String cssSelector){
        new WebDriverWait(navegador, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
    }
}
