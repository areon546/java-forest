package forest.domain.time;

public class Time {
    int hour, min;
    public Time(int hour, int min) {
    this.hour=hour;
    this.min=min;
    }

    public void increment(int min) {
        this.min += min;

        while (this.min >= 60) {
            this.min-=60;
            this.hour+=1;
        }
    }

    public int hour() {
        return this.hour;
    }

    public int minute() {
        return this.min;
    }

    public long seed() {
        return (long) this.hour*100 + this.min;
    }

    public void set(int hour, int min) {
        this.hour=hour;
        this.min=min;
    }

    public void print() {
        System.out.printf("It is now: %d:%02d", hour, min, String.format("%0" + 1 + "d", min));
    }
}
