package framework.steps;

import framework.page.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class step {
    Page p = new Page();

    @Given("open page \"Главная\"")
    public void open() {
        p.initPage();

    }

    @Given("element visible {string}")
    public void element_visible(String string) {
        p.elementVisible(string);
    }

    @Given("click on {string}")
    public void click_on(String string) {
        p.click(string);
    }

    @Given("element send {string}")
    public void sendk(String string){
        p.sendkey(string);
    }

}
