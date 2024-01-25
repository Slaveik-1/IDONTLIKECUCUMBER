# language: ru

@API
@all

Функция: Rest api тест


  Структура сценария: Добавление товара
    * Получена таблица
    Затем добавляются значения
      |field|value|
      |name |<apiName>|
      |type |<apiType>|
      |exotic|<apiExotic>|
    * Получена таблица
    * Таблица содержит поля
      |field|value|
      |name |<apiName>|
      |type |<apiType>|
      |exotic|<apiExotic>|
    * Таблица сбрасывается

    Примеры:
      |apiName|apiType|apiExotic|
      |Цукини256?|VEGETABLE|true|
      |Груша:с|FRUIT|false|