package dragon.forest;

import dragon.forest.collections.Events;
import dragon.forest.collections.Explorer;
import dragon.forest.collections.Items;
import dragon.forest.locations.Forest;
import dragon.forest.locations.SaveFountain;
import dragon.forest.locations.Town;
import dragon.forest.time.Day;
import dragon.forest.time.Time;
import dragon.forest.util.util;

import static dragon.forest.util.util.InputChar;

public class ForestGame {
    static Explorer character;

    public static void main(String[] args) {
        loadData();

        printWelcome();

        getCharacter();

        play();
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

    /* Game Cycle:
    - Wake up
    - GOTO Forest or Town
    - Go to Forest
     - Encounter Things and Gather Resources
    - Go home after XYZ
    - Prep at home (Weapons, Poison, ETC)
    -
    */
    static void play() {
        Day day = new Day(0);
        Time time = new Time(9, 0);


        char c = InputChar("""
                Do you want to go to the: 
                [T]own 
                [F]orest  
                [S]ave Fountain """, new char[] {'T', 'F', 'S'});


        switch (c) {
            case 'T':
                Town.enterTown(character, day, time);
                break;
            case 'F':
                Forest.enterForest(character, day, time);
                break;
            case 'S':
                SaveFountain.bathe(character, day, time);
        }

    }

    static void loadData() {
        Items.loadData();
        Events.loadData();

    }
}
