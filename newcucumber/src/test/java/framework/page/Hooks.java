package framework.page;

import framework.managers.WebDriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

    @BeforeAll
    public static void before_all(){
        WebDriverManager.initDriver();

    }

    @Before
    public static void before(){
        WebDriverManager.getWebDriver().get("http://localhost:8080");
    }



    @AfterAll
    public static void after_all(){
        WebDriverManager.quit();
    }
}
