@UI
@all

  Feature: dobavlenie tovara

    Scenario:yspeshnoe dobavlenie tovara
      * open page "Главная"
      * element visible "Главная"
      * element visible "Песочница"
      * click on "Песочница"
      * element visible "Товары"
      * click on "Товары"
      * element visible "Список Товаров"
      * element visible "Добавить"
      * click on "Добавить"
      * element visible "Добавление товара"
      * element visible "Наименование"
      * element visible "Тип"
      * element visible "Чекбокс"
      * element visible "Сохранить"
      * element send "Цукини256"
      * click on "Овощ"
      * click on "Чекбокс"
      * click on "Сохранить"
      * open page "Главная"
      * element visible "Список Товаров"
      * element visible "Добавить"
      * click on "Добавить"
      * element visible "Добавление товара"
      * element visible "Наименование"
      * element visible "Тип"
      * element visible "Чекбокс"
      * element visible "Сохранить"
      * element send "Груша:с"
      * click on "Фрукт"
      * click on "Чекбокс"
      * click on "Сохранить"
      * open page "Главная"
      * element visible "Песочница"
      * click on "Песочница"
      * element visible "Сбросить"






      




