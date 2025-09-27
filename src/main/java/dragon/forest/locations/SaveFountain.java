package dragon.forest.locations;

import dragon.forest.collections.Explorer;
import dragon.forest.time.Day;
import dragon.forest.time.Time;
import dragon.forest.util.util;

public class SaveFountain {
    public static void bathe(Explorer character, Day day, Time t) {
        util.Output(character.Name() + " bathes until the sun goes down. ");

    }
}
