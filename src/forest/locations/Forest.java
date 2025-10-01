package forest.locations;

/*
The Forest class represents a digital forest the Explorer visits through their days.

They [C]ollect Herbs here, [F]ight Creatures, and [T]alk with people they meet in the forest.
The forest is ever shifting. Upon [S]leeping it resets.
*/

import forest.domain.Explorer;
import forest.domain.map.Map;
import forest.domain.time.Day;
import forest.domain.time.Time;
import forest.util.util;

public class Forest extends Area {
    Map map;

    @Override
    public void enter(Explorer character, Day d, Time t) {
        explorer=character;
        day=d;
        time=t;

        map = new Map(character.seed() ^ d.seed());

        util.Output(String.format("Welcome %s, you are here to collect herbs and preserve the Wildlife. Do not Anger the Forest. ", character.name()));

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
                """, util.allowed("NESWL"));

            walk(direction);

        } while (direction != 'L');

        leave();
    }

    // The character leaves the forest, it takes an hour to leave.
    @Override
    public void leave() {
        time.increment(60);
        time.print();


        util.Output("You left the forest. It is now evening. ");


    }

    private void walk(char direction) {
        time.increment(30);
        time.print();
        Event event;

        switch (direction) {
            case 'N':
                event = map.goNorth();
                event.enter(explorer, day, time);
                break;
            case 'E':
                event = map.goEast();
                event.enter(explorer, day, time);
                break;
            case 'S':
                event = map.goSouth();
                event.enter(explorer, day, time);
                break;
            case 'W':
                event = map.goWest();
                event.enter(explorer, day, time);
                break;
        }
    }

} // END forest
