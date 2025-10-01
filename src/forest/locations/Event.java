package forest.locations;

import forest.domain.Explorer;
import forest.domain.map.Location;
import forest.domain.time.Day;
import forest.domain.time.Time;
import forest.util.util;

import java.util.Random;

/*
The Encounter class represents
 */
public class Event extends Area {

    private final Location coords;
    private float reputationChange = 0f;
    private String description;

    public Event(Location loc) {
        this.coords=loc;
    }


    @Override
    void enter(Explorer e, Day d, Time t) {
        explorer=e;
        day=d;
        time=t;

        generate(coords.seed());
    }


    /**
     * Leaving an event adjusts the player's reputation.
     */
    @Override
    void leave() {
        explorer.adjustReputation(reputationChange);
    }

    private void generate(long seed) {
        Random r = new Random(seed);
        Float rng = r.nextFloat();

        description = "The forest smells earthy. \n";


    }

    public String description() {
        return description + "\n";
    }
}

