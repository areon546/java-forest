package forest.locations;

/*
The Forest class represents a digital forest the Explorer visits through their days.

They [C]ollect Herbs here, [F]ight Creatures, and [T]alk with people they meet in the forest.
The forest is ever shifting. Upon [S]leeping it resets.
*/

import forest.collections.Explorer;
import forest.map.Map;
import forest.time.Day;
import forest.time.Time;
import forest.util.util;

public class Forest {
    static Map map;
    static Time time;
    public static void enterForest(Explorer character, Day d, Time t) {
        map = new Map(character.seed() ^ d.seed());
        time=t;

        // Ask where to go
        char direction;

        do {
            direction = util.InputChar("""
                Where do you want to go?
                [N] North
                [E] East
                [S] South
                [W] West
                [L] Leave
                """, util.allowed("NESWL"));} while (direction != 'L');

    }

    private void walk(char direction) {

        switch (direction) {
            case 'N':
                map.goNorth();
                break;
            case 'E':
                map.goEast();
                break;
            case 'S':
                map.goSouth();
                break;
            case 'W':
                map.goWest();
                break;
        }

        util.Output(map.Look(time));

    }

} // END forest
