package forest.domain.map;

import forest.util.Seed;

public class Location {
    int north, east;

    public Location(int north, int east) {
        this.north= north;
        this.east= east;
    }

    public String toString() {
        return "X:" + this.north + " Y:" + this.east;
    }

    public long seed() {
        return Seed.New(toString());
    }

}