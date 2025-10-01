package forest.locations;

import forest.domain.Explorer;
import forest.domain.time.Day;
import forest.domain.time.Time;
import forest.util.util;

public class SaveFountain extends Area {

    @Override
    public void enter(Explorer e, Day d, Time t) {
        bathe(e, d, t);
    }

    @Override
    public void leave() {

    }

    private void bathe(Explorer character, Day day, Time t) {
        util.Output(character.Name() + " bathes until the sun goes down. ");
        util.Output("TODO: Save and Load character. ");

    }
}
