package framework.steps;

import framework.managers.WebDriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {
    public static final String base = "http://localhost:8080/";
    public static final String rem = "http://149.154.71.152:8080/";

    @BeforeAll
    public static void before_all(){
        WebDriverManager.initDriver();
    }

    @Before
    public static void before(){
        WebDriverManager.getWebDriver().get(base);
    }



    @AfterAll
    public static void after_all(){
        WebDriverManager.quit();
    }

}
