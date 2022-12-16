package tests;

import Factory.DSL;
import Pages.BlogAgiInicialPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.time.Duration;

public class BlogAdoAgiTests {
    private WebDriver navegador;
    private DSL dsl;
    private BlogAgiInicialPage bloAgiInicialPage;
    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        navegador = new ChromeDriver(options);
        navegador.get("https://blogdoagi.com.br/");
        dsl = new DSL(navegador);
        bloAgiInicialPage = new BlogAgiInicialPage(navegador);
    }
    @Test
    public void ValiddateIfTheSearchBorughAResult(){
        bloAgiInicialPage.clickSearch("search-open");
        bloAgiInicialPage.escreverPesquisa("input[type=search]", "Emprego");
        bloAgiInicialPage.clickPesquisar("input[type=submit]");

        String resultado = navegador.findElement(By.cssSelector("h1")).getText();
        Assert.assertTrue(resultado.contains("busca"));

    }

    @Test
    public void ValiddateResultNotFound(){

        bloAgiInicialPage.clickSearch("search-open");
        bloAgiInicialPage.escreverPesquisa("input[type=search]", "DSFADSFDSFASDFASDF");
        bloAgiInicialPage.clickPesquisar("input[type=submit]");

        String resultado = navegador.findElement(By.cssSelector("h1")).getText();
        Assert.assertTrue(resultado.contains("Nenhum "));

    }

    @After
    public void finaliza(){
        navegador.quit();
    }
}
