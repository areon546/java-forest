package forest.locations;

import forest.domain.Explorer;
import forest.domain.time.Day;
import forest.domain.time.Time;
import forest.util.util;

import static forest.util.util.InputChar;

public class GameCycle extends Area {
    private Town town;

    public GameCycle(Town t) {
        this.town = t;
    }


    @Override
    public void enter(Explorer e, Day d, Time t) {
        explorer=e;
        day=d;
        time=t;

        char c = InputChar("""
                Do you want to go to the:
                [T] Town
                [F] Forest
                [S] Save Fountain""", util.allowed("TFS"));


        switch (c) {
            case 'T':
                town.enter(e, d, t);
                break;
            case 'F':
                new Forest().enter(e, d, t);
                break;
            case 'S':
                new SaveFountain().enter(e, d, t);
        }
    }

    @Override
    public void leave() {

    }
}
