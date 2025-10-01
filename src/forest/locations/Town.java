package forest.locations;

import forest.collections.Buildings;
import forest.collections.TownBuilding;
import forest.domain.Explorer;
import forest.domain.time.Day;
import forest.domain.time.Time;
import forest.util.util;

/*
In the town, I want the user to be able to visit different buildings.
In each building, you can do things such as visit them, and talk to the inhabitant.
Conversations will be limited as currently I want to design the story, later on I can add conversations.
 */
public class Town extends Area {
    private Buildings buildings;

    public Town(Buildings buildings) {
        this.buildings=buildings;
    }

    /**
     * Here the user is able to select a specific building to look at.
     *
     * @param e Explorer, transferred to pass on user info.
     * @param d Day, transferred to have information about what events can happen on what day.
     * @param t Time, transferred for finer control over time within Areas.
     */
    @Override
    public void enter(Explorer e, Day d, Time t) {
        explorer=e;
        day=d;
        time=t;

        util.Output(this.buildings.toString());

        whichBuilding();
    }


    /**
     * Leave provides an opportunity to either:
     * - stay
     * - leave
     * It doesn't judge based on
     */
    @Override
    public void leave() {

        String question = "Do you want to: ";
        Character[] opts = new Character[] {'S', 'L'};
        String[] desc = new String[] {"Stay", "Leave"};

        char c = util.ask(question, opts, desc);

        switch (c) {
            case 'S':
                whichBuilding();
                break;
            case 'L':
                new GameCycle(this).enter(explorer, day, time);
        }
    }

    public Buildings getBuildings() {
        return buildings;
    }



    private void whichBuilding() {
        String q = """
                What building would you like to look at?
                """;

        char b = util.ask(q, buildings.getLabels(), buildings.getNames());

        TownBuilding building = buildings.getBuildingByLabel(b);
        interact(building);
        leave();
    }

    /**
     * Goes through the general process of either: Repairing a building, or Visiting its contents.
     * @param building
     */
    private void interact(TownBuilding building) {
        // Ask about repairing the building.
//        String q = "The " + building.getName() + " requires some resources, " + building.getMats().toString() + "\nDo you have any?";
//        Character[] opts = building.get(building).getLabels();
//        String[] desc = building.get(building).getNames();
//
//        char material = util.ask(q, opts, desc);




    }
}
