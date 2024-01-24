package framework.steps;

import DbPichypido.Foodhell;
import DbPichypido.Pichupido;
import io.cucumber.java.ru.Допустим;

import java.sql.ResultSet;

public class stepbd {

    private ResultSet resultSet;


    @Допустим("^добавить \"([^\"]*)\", (FRUIT|VEGETABLE), (true|false)$")
    public void add(String name, String type, String exotic) {
        boolean exo = Boolean.parseBoolean(exotic);
        Foodhell food = Foodhell.getThis(type);
        Pichupido.getDBInstance().insertRow(name, food, exo);
    }
    @Допустим("Получить БД с новыми товарами")
    public void save(){
        resultSet = Pichupido.getDBInstance().getContents();
    }
    @Допустим("Полученна бд")
    public void hehe(){
        resultSet = Pichupido.getDBInstance().getContents();
    }
}

