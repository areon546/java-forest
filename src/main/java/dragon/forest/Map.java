package dragon.forest;

import java.util.HashMap;

// A map used by explorers.
public class Map {
    private final HashMap<location, mapNode> map = new HashMap<location, mapNode>();
    private location currLoc;

    // Generates a map.
    public Map() {
        this.currLoc = new location(0,0);
        this.generate(this.currLoc);
    }

    // Peek into the map element at the given location.
    public String Look() {
        return this.map.get(this.currLoc).getDescription();
    }

    private void generate(location loc) {
        mapNode node = new mapNode(loc);
        this.map.put(loc, node);
    }


    // Travelling means a new map node in the given location is generated.

    // Travel North in Map
    public void goNorth() {
        this.currLoc = new location(this.currLoc.north+1, this.currLoc.east);
        this.generate(this.currLoc);
    }

    // Travel South in Map
    public void goSouth() {
        this.currLoc = new location(this.currLoc.north-1, this.currLoc.east);
        this.generate(this.currLoc);
    }

    // Travel East in Map
    public void goEast() {
        this.currLoc = new location(this.currLoc.north, this.currLoc.east+1);
        this.generate(this.currLoc);
    }

    // Travel West in Map
    public void goWest() {
        this.currLoc = new location(this.currLoc.north, this.currLoc.east-1);
        this.generate(this.currLoc);
    }
}

class mapNode {
    location loc;

    String desc, event;

    mapNode(location loc) {
        this.loc=loc;
        this.generate();
    }

    /*
     * Generates information regarding contents of the mapNode
     *
     * Should use information about location and day here to generate random stuff every day, or set based on seed.
     */
    private void generate() {
        this.desc = "HI I AM AN EMPTY TILE: " + this.loc.toString();
    }

    String getDescription() {
        return this.desc;
    }

    location getLoc() {
        return this.loc;
    }

}


class location {
    int north, east;

    location(int north, int east) {
        this.north= north;
        this.east= east;
    }

    public String toString() {
        return "X:" + this.north + " Y:" + this.east;
    }

}