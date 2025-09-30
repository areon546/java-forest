package forest.map;

import forest.time.Time;

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

    // Peek into the map element at the given location.
    public String Look(Time t) {
        return this.map.get(this.currLoc).getDescription();
    }

    private void generate(Location loc) {
        MapNode node = new MapNode(loc);
        this.map.put(loc, node);
    }

    // Let the seed for the random events be set manually.
    void seed(long seed) {
        this.rng = new Random(seed);
    }


    // Travelling means a new map node in the given location is generated.

    // Travel North in Map
    public void goNorth() {
        this.currLoc = new Location(this.currLoc.north+1, this.currLoc.east);
        this.generate(this.currLoc);
    }

    // Travel South in Map
    public void goSouth() {
        this.currLoc = new Location(this.currLoc.north-1, this.currLoc.east);
        this.generate(this.currLoc);
    }

    // Travel East in Map
    public void goEast() {
        this.currLoc = new Location(this.currLoc.north, this.currLoc.east+1);
        this.generate(this.currLoc);
    }

    // Travel West in Map
    public void goWest() {
        this.currLoc = new Location(this.currLoc.north, this.currLoc.east-1);
        this.generate(this.currLoc);
    }
}

