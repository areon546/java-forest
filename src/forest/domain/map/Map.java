package forest.domain.map;

import forest.domain.time.Time;
import forest.locations.Event;

import java.util.HashMap;
import java.util.Random;

// A map used by explorers.
public class Map {
    private final HashMap<Location, MapNode> map = new HashMap<Location, MapNode>();
    private Location currLoc;

    private Random rng;

    // Generates a map.
    public Map() {
        this.currLoc = new Location(0,0);
        this.generate(this.currLoc);
        this.rng = new Random();
    }

    public Map(long seed) {
        this.currLoc = new Location(0,0);
        this.generate(this.currLoc);

        this.seed(seed);
    }

    // Return the description of the current location at the given time.
    public String look(Time t) {
        return this.map.get(this.currLoc).getDescription();
    }

    private Event generate(Location loc) {
        MapNode node = new MapNode(loc);
        this.map.put(loc, node);

        return node.generate();
    }

    // Let the seed for the random events be set manually.
    void seed(long seed) {
        this.rng = new Random(seed);
    }


    // Travelling means a new map node in the given location is generated.

    // Travel North in Map
    public Event goNorth() {
        currLoc = new Location(this.currLoc.north+1, this.currLoc.east);
        return generate(this.currLoc);
    }

    // Travel South in Map
    public Event goSouth() {
        this.currLoc = new Location(this.currLoc.north-1, this.currLoc.east);
        return generate(this.currLoc);
    }

    // Travel East in Map
    public Event goEast() {
        this.currLoc = new Location(this.currLoc.north, this.currLoc.east+1);
        return generate(this.currLoc);
    }

    // Travel West in Map
    public Event goWest() {
        this.currLoc = new Location(this.currLoc.north, this.currLoc.east-1);
        return generate(this.currLoc);
    }
}

