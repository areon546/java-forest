package forest;

import forest.collections.Buildings;
import forest.collections.Materials;
import forest.collections.Resource;
import forest.collections.TownBuilding;
import forest.domain.Explorer;
import forest.locations.GameCycle;
import forest.locations.Town;
import forest.domain.time.Day;
import forest.domain.time.Time;
import forest.util.util;

public class ForestGame {
    static Explorer character;
    static Town town;

    public static void main(String[] args) {
        loadData();

        printWelcome();

        getCharacter();

        start();
    }

    // Prints a small amount of Art to represent the game.
    static void printWelcome() {
        util.Output("WELCOME TO THE FOREST!!!");
    }


    // Load character (from savefile or new)
    static void getCharacter() {
        generateCharacter();
    }

    // Generates a New Character.
    static void generateCharacter() {
        String name = util.Input("Input NAME for EXPLORER: ");
        character = new Explorer(name);

        util.Output("HI " + character.toString());
    }

    static void start() {
        Day day = new Day(0);
        Time time = new Time(9, 0);
        play(day, time);
    }


    static void play(Day day, Time time) {
        GameCycle gc = new GameCycle(town);
        boolean test = false;

        if (test) {
            town.enter(character, day, time);
            return;
        }

        gc.enter(character, day, time);
    }

    static void loadData() {
        Buildings b = new Buildings();
        b.addBuilding(TownBuilding.FISH, new Materials().addMaterial(Resource.STONE, 5));
        town = new Town(b);
    }
}
