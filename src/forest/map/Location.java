package forest.map;

class Location {
    int north, east;

    public Location(int north, int east) {
        this.north= north;
        this.east= east;
    }

    public String toString() {
        return "X:" + this.north + " Y:" + this.east;
    }

}