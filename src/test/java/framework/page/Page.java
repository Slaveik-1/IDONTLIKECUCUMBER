package framework.page;
//div[@class='container-fluid']/*[1]

import framework.managers.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Page {

    protected WebDriverWait wait = new WebDriverWait(WebDriverManager.getWebDriver(), 10L);

    protected Map<String, String> myloveMap = new HashMap<String, String>();


    public void initPage() {
        if(myloveMap == null || myloveMap.size() == 0) {
            myloveMap.put("Добавить", "//button[@data-toggle='modal']");
            myloveMap.put("Список Товаров", "//div[@class='container-fluid']/*[1]");
            myloveMap.put("Добавление товара", "//h5[@class='modal-title']");
            myloveMap.put("Наименование", "//input[@id='name']");
            myloveMap.put("Тип", "//select[@id='type']");
            myloveMap.put("Чекбокс", "//input[@type='checkbox']");
            myloveMap.put("Сохранить", "//button[@id='save']");
            myloveMap.put("Главная", "//a[@class='navbar-brand']");
            myloveMap.put("Песочница", "//a[@id='navbarDropdown']");
            myloveMap.put("Товары", "//a[@class='dropdown-item'][@href='/food']['Товары']");
            myloveMap.put("Сбросить", "//a[@class='dropdown-item'][@id='reset']");
            myloveMap.put("Фрукт", "//*[@value='FRUIT']");
            myloveMap.put("Овощ", "//*[@value='VEGETABLE']");
        }

    }
    public WebElement getElement(String a){
        try {
            WebElement e = WebDriverManager.getWebDriver().findElement(By.xpath(myloveMap.get(a)));
            return e;
        }
        catch (TimeoutException e){
            return stubbornWait(a);
        }
    }
    public void elementVisible(String a){

        try {
            wait.until(ExpectedConditions.visibilityOf(getElement(a)));
        }
        catch (StaleElementReferenceException e){
            stubbornWait(a);
        }
        catch (TimeoutException e){
            stubbornWait(a);
        }
    }

    public void click(String a){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(getElement(a))).click();
        }
        catch (TimeoutException e) {
            stubbornWait(a).click();
        }

    }

    public void sendkey(String string){
        wait.until(ExpectedConditions.elementToBeClickable(getElement("Наименование"))).sendKeys(string);
    }

    public WebElement stubbornWait(String name) {
        Wait<WebDriver> stubbornWait = new FluentWait<WebDriver>(WebDriverManager.getWebDriver())
                .withTimeout(Duration.ofSeconds(360))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        WebElement e = stubbornWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(
                        myloveMap.get(name)));
            }
        });

        return null;
    }




}
