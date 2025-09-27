package dragon.forest.map;

class MapNode {
    Location loc;

    String desc, event;

    public MapNode(Location loc) {
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

    public String getDescription() {
        return this.desc;
    }

    public Location getLoc() {
        return this.loc;
    }

}


