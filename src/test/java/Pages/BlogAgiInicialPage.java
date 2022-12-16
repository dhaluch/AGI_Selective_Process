package Pages;

import Factory.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BlogAdoAgiTests;

import java.time.Duration;

public class BlogAgiInicialPage {
    private DSL dsl;
    //private WebDriver navegador;


    public BlogAgiInicialPage(WebDriver navegador){
        dsl = new DSL(navegador);
    }

    public void clickSearch(String id){
        dsl.AguardarPorId(id);
        dsl.clickId(id);

    }
    public void clickSubmit(String cssSelector){
        dsl.click(cssSelector);
    }
    public void escreverPesquisa(String CssSelector, String Texto){
        dsl.AguardarCssSelector(CssSelector);
        dsl.escreve(CssSelector, Texto);
    }
    public void clickPesquisar(String CssSelector){
        dsl.click(CssSelector);
    }


}
