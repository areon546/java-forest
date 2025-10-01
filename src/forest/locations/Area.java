package forest.locations;

import forest.domain.Explorer;
import forest.domain.time.Day;
import forest.domain.time.Time;

public abstract class Area {
    Explorer explorer;
    Day day;
    Time time;


    /*
    Two different types of implementation.
    A location and a aadsa.

    location:
    - locations let the user choose whether to leave, leaving


    */
    abstract void enter(Explorer e, Day d, Time t);

    /* Can be left as blank. */
    abstract void leave();


}
