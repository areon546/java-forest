package forest.collections;

/**
 * TownBuilding enum class contains a list of all buildings in the game.
 */
public enum TownBuilding {
    TOWN_HALL('H', "Town Hall"),
    BUTCHER('B', "Butcher"),
    FISH('F', "Fishmonger")

    ;


    // Object
    private char input;
    private String name;

    TownBuilding(char input, String name) {
        this.input=input;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public char getInput() {
        return input;
    }
}
