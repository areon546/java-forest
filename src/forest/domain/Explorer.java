package forest.domain;

import forest.collections.Materials;
import forest.collections.Resource;
import forest.util.Seed;

public class Explorer {
    private final String name;
    private final Materials inventory = new Materials();
    private float reputation = 10.0f;

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


    public String name() {
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

    /**
     * Adjust reputation by parameter `reputationChange` by quantity. It can go negative.
     * @param reputationChange
     */
    public void adjustReputation(float reputationChange) {
        this.reputation += reputationChange;
    }
}
