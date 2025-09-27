package dragon.forest.locations;

/*
The Forest class represents a digital forest the Explorer visits through their days.

They [C]ollect Herbs here, [F]ight Creatures, and [T]alk with people they meet in the forest.
The forest is ever shifting. Upon [S]leeping it resets.
*/

import dragon.forest.collections.Explorer;
import dragon.forest.map.Map;
import dragon.forest.time.Day;
import dragon.forest.time.Time;

public class Forest {
    static Map map;
    public static void enterForest(Explorer character, Day d, Time t) {
        map = new Map(character.seed() ^ d.seed());

        // Ask where to go


        System.out.println(map.Look(t));
        map.goEast();
        System.out.println(map.Look(t));
    }

} // END forest
