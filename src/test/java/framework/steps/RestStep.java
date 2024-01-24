package framework.steps;

import DbPichypido.Food;
import Rest.RestTest;
import io.cucumber.java.ru.Допустим;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class RestStep {
    @Допустим("Получена таблица")
    public List<Food> getTable(){
        List<Food> fod = RestTest.getItem(ContentType.JSON, 200);
        return fod;
    }
    @Допустим("добавляются значения")
    public void addTable(Map<String , String> string){
        String name = string.get("name");
        String type = string.get("type");
        boolean exotic = Boolean.parseBoolean(string.get("exotic"));
        RestTest.addItems(name, type, exotic, 200);
    }
    @Допустим("Таблица содержит поля")
    public void apiPage(Map<String, String> string){
        List<Food> fod = getTable();
        String name = string.get("name");
        String type = string.get("type");
        boolean exotic = Boolean.parseBoolean(string.get("exotic"));
        Food neew = new Food();
        neew.setName(name);
        neew.setType(type);
        neew.setExotic(exotic);

        Assertions.assertEquals(neew.getName(), fod.get(fod.size() - 1).getName());
        Assertions.assertEquals(neew.getType(), fod.get(fod.size() - 1).getType());
        Assertions.assertEquals(neew.getExotic(), fod.get(fod.size() - 1).getExotic());

    }

    @Допустим("Таблица сбрасывается")
    public void tableReset(){
        RestTest.rest(200);

    }




}
