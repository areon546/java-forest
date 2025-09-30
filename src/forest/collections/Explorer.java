package forest.collections;

import forest.util.Seed;

import java.util.Map;

public class Explorer {
    String name;
    Map<Item, Integer> items;

    public Explorer(String name) {
        this.name=name;
    }

    @Override
    public String toString() {return this.name;}

    // Uses Explorer metadata and converts it into a long for usage by Map.rng attribute.
    public long seed() {
        long nameSeed = Seed.New(this.name);

        return nameSeed;
    }


    public String Name() {
        return this.name;
    }
}
