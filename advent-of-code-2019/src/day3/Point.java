package day3;

public class Point {
    int x, y, steps;

    public Point(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps; // how many steps it's taken to get here so far
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
