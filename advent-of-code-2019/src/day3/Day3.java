package day3;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    public static void main(String[] args) throws Exception {
        File f = new File("./day3_input.txt");
        Scanner scanner = new Scanner(f);
        String[] line1 = scanner.next().split(",");
        String[] line2 = scanner.next().split(",");
        Line lineA = computeLine(line1);
        Line lineB = computeLine(line2);
        List<Point> intersections = findIntersections(lineA, lineB);
        System.out.println(fewestSteps(intersections));
        scanner.close();
    }

    public static Line computeLine(String[] input) {
        Line line = new Line(input.length);
        for(int i = 0; i < input.length; i++) {
            char dir = input[i].charAt(0);
            int dist = Integer.parseInt(input[i].substring(1));
            line.addInterval(dir, dist);
        }
        return line;
    }

    public static List<Point> findIntersections(Line lineA, Line lineB) {
        List<Point> intersections = new LinkedList<>();
        for(int i = 0; i < lineA.intervals.size(); i++) {
            Interval currA = lineA.intervals.get(i);
            // if it's horizontal, show hor range, check same vert
            for(int j = 0; j < lineB.intervals.size(); j++) {
                Interval currB = lineB.intervals.get(j);
                Interval horizontal = currB, vertical = currA;
                if(currA.dir == 'L' || currA.dir == 'R') {
                    // line A is vertical
                    if(currB.dir == 'L' || currB.dir == 'R') continue;
                    else {
                        vertical = currB;
                        horizontal = currA;
                    }
                } else if(currB.dir == 'U' || currB.dir == 'D') continue;
                int xIntersection = vertical.start.x;
                int yIntersection = horizontal.start.y;
                if(xIntersection > Math.min(horizontal.start.x, horizontal.end.x) && xIntersection < Math.max(horizontal.start.x, horizontal.end.x)
                && yIntersection > Math.min(vertical.start.y, vertical.end.y) && yIntersection < Math.max(vertical.start.y, vertical.end.y)) {
                    int stepsVertical = vertical.end.steps - Math.abs(vertical.end.y - yIntersection);
                    int stepsHorizontal = horizontal.end.steps - Math.abs(horizontal.end.x - xIntersection);
                    intersections.add(new Point(xIntersection, yIntersection, stepsHorizontal + stepsVertical));
                }
            }
        }
        return intersections;
    }

    public static int closest(List<Point> intersections) {
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < intersections.size(); i++) {
            int distanceX = Math.abs(intersections.get(i).x);
            int distanceY = Math.abs(intersections.get(i).y);
            closest = Math.min(closest, distanceX + distanceY);
        }
        return closest;
    }

    public static int fewestSteps(List<Point> intersections) {
        int fewestSteps = Integer.MAX_VALUE;
        for(int i = 0; i < intersections.size(); i++) {
            fewestSteps = Math.min(intersections.get(i).steps, fewestSteps);
        }
        return fewestSteps;
    }


}
