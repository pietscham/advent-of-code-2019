package day3;

public class Interval {

    // each interval has a point a, and point b
    // each interval has a dir
    Point start, end;
    char dir;
    public Interval(Point a, Point b, char dir) {
        start = a;
        end = b;
        this.dir = dir;
    }

}
