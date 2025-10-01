package forest.domain.map;

import forest.locations.Event;

class MapNode {
    Location loc;

    String desc;
    Event event;

    public MapNode(Location l) {
        loc=l;
    }

    /*
     * Generates information regarding contents of the mapNode
     *
     * Should use information about location and day here to generate random stuff every day, or set based on seed.
     */
    public Event generate() {
        event = new Event(loc);

        return event;
    }

    public String getDescription() {
        return event.description();
    }

    public Location getLoc() {
        return this.loc;
    }

}


