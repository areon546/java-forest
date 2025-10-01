package forest.domain;

import forest.collections.Materials;
import forest.collections.Resource;
import forest.util.Seed;

public class Explorer {
    private String name;
    private Materials inventory = new Materials();

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

    /**
     * Adds `quantity` of a specific resource to the player's inventory.
     * @param r             Specific resource to add.
     * @param quantity      Quantity of resource to add.
     */
    public void add(Resource r, int quantity)  {
        inventory.get(r).adjustQuantity(quantity);
    }
}
