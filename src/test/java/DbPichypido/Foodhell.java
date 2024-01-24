package DbPichypido;

public enum Foodhell {
    FRUIT ("Фрукт", "FRUIT"),
    VEGETABLE ("Овощ", "VEGETABLE");

    private final String rus;
    private final String eng;
    Foodhell(String rus, String eng) { this.rus = rus; this.eng = eng; }

    public static Foodhell getThis(String rus) {
        switch (rus) {
            case "Овощ":
            case "VEGETABLE":
                return Foodhell.VEGETABLE;
            case "Фрукт":
            case "FRUIT":
                return Foodhell.FRUIT;
        }
        return null;
    }

    public String getFruitNameRus() { return rus; }
    public String getFruitNameEng() { return eng; }
}

//Честно арендованное != сворованное