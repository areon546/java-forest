package forest.locations;

import forest.collections.Resource;
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
    private Random r;

    public Event(Location loc) {
        this.coords=loc;
    }


    @Override
    void enter(Explorer e, Day d, Time t) {
        explorer=e;
        day=d;
        time=t;

        generate(coords.seed());

        util.Output(description);
        leave();
    }


    /**
     * Leaving an event adjusts the player's reputation.
     */
    @Override
    void leave() {
        explorer.adjustReputation(reputationChange);
    }

    private void generate(long seed) {
        r = new Random(seed);
        Float rng = r.nextFloat();

        description = "The forest smells earthy. \n";

        if (rng < 0.05f) {
            // 5%
            specialEvent();
        } else if (rng < 0.35f) {
            // 30%
            animalRuns();
        } else if (rng < 0.45f) {
            // 10%
            animalSick();
        } else if (rng < .7f) {
            // 25%
            collectHerb();
        } else if (rng < 0.9f) {
            // 20%
            collectBark();
        } else {
            // remainder: 10%
            nothingHappens();
        }
    }


    public String description() {
        return description + "\n";
    }


    private void nothingHappens() {
        String s = "Nothing happens";

        description += s;
    }

    private void collectBark() {
        String s = "You found some bark";

        explorer.add(Resource.BARK, 1);

        description += s;
    }

    private void collectHerb() {
        String s = "You found a herb";

        explorer.add(Resource.HERB, 1);

        description += s;
    }

    private void animalSick() {
        String s = "Animal is Sick";

        description += s;
    }

    private void animalRuns() {
        String s = "Animal Runs away";

        description += s;
    }

    private void specialEvent() {
        String s = "Special Event!!";

        explorer.add(Resource.BLOOD, 1);

        description += s;
    }

}

