package framework.page;
//div[@class='container-fluid']/*[1]

import framework.managers.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Page {

    protected WebDriverWait wait = new WebDriverWait(WebDriverManager.getWebDriver(), Duration.ofSeconds(5));

    protected Map<String, String> elementMap = new HashMap<String, String>();


    public void initPage() {
        if(elementMap == null || elementMap.size() == 0) {
            elementMap.put("Добавить", "//button[@data-toggle='modal']");
            elementMap.put("Список Товаров", "//div[@class='container-fluid']/*[1]");
            elementMap.put("Добавление товара", "//h5[@class='modal-title']");
            elementMap.put("Наименование", "//input[@id='name']");
            elementMap.put("Тип", "//select[@id='type']");
            elementMap.put("Чекбокс", "//input[@type='checkbox']");
            elementMap.put("Сохранить", "//button[@id='save']");
            elementMap.put("Главная", "//a[@class='navbar-brand']");
            elementMap.put("Песочница", "//a[@id='navbarDropdown']");
            elementMap.put("Товары", "//a[@class='dropdown-item'][@href='/food']['Товары']");
            elementMap.put("Сбросить", "//a[@class='dropdown-item'][@id='reset']");
            elementMap.put("Фрукт", "//*[@value='FRUIT']");
            elementMap.put("Овощ", "//*[@value='VEGETABLE']");
        }

    }
    public WebElement getElement(String a){
        WebElement e = WebDriverManager.getWebDriver().findElement(By.xpath(elementMap.get(a)));
        return e;
    }
    public void elementVisible(String a){
        wait.until(ExpectedConditions.visibilityOf(getElement(a)));
    }

    public void click(String a){
        wait.until(ExpectedConditions.elementToBeClickable(getElement(a))).click();
    }

    public void sendkey(String string){
        wait.until(ExpectedConditions.elementToBeClickable(getElement("Наименование"))).sendKeys(string);



    }




}
