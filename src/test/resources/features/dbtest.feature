# language: ru

@DB

Функция: Добавление в бд

  Сценарий: Успешное добавление новых строк в БД - сценарий 1
    * Полученна бд
    * добавить "Мандарин", FRUIT, true
    * Получить БД с новыми товарами