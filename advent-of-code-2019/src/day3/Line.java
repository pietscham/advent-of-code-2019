package day3;

import java.util.ArrayList;
import java.util.List;

public class Line {

    List<Interval> intervals;
    Point currPoint;
    int steps;

    public Line(int size) {
        intervals = new ArrayList<>(size);
        currPoint = new Point(0, 0, 0);
        steps = 0;
    }

    public void addInterval(char dir, int dist) {
        Point a = new Point(currPoint.x, currPoint.y, this.steps);
        steps+=Math.abs(dist);
        switch(dir) {
            case 'U': {
                Point b = new Point(currPoint.x, currPoint.y + dist, this.steps);
                intervals.add(new Interval(a, b, dir));
                currPoint.setY(currPoint.y + dist);
                break;
            }
            case 'D': {
                Point b = new Point(currPoint.x, currPoint.y - dist, this.steps);
                intervals.add(new Interval(a, b, dir));
                currPoint.setY(currPoint.y - dist);
                break;
            }
            case 'R': {
                Point b = new Point(currPoint.x + dist, currPoint.y, this.steps);
                intervals.add(new Interval(a, b, dir));
                currPoint.setX(currPoint.x + dist);
                break;
            }
            case 'L': {
                Point b = new Point(currPoint.x - dist, currPoint.y, this.steps);
                intervals.add(new Interval(a, b, dir));
                currPoint.setX(currPoint.x - dist);
                break;
            }

        }
    }
}
