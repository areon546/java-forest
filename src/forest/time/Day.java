package forest.time;

public class Day {
    int day;

    public Day(int day) {
        this.day=day;
    }

    public void increment() {
        this.day+=1;
    }

    public long seed() {
        return (long) this.day;
    }
}
