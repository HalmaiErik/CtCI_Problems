package CH7_RecursionAndDynamProg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RobotInGrid {
    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static List<Point> getPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }

        List<Point> path = new LinkedList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(grid, failedPoints, grid.length - 1, grid[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] grid, HashSet<Point> failedPoints, int row, int col,
                                    List<Point> path) {
        if (col < 0 || row < 0 || !grid[row][col]) {
            return false;
        }

        Point p = new Point(row, col);
        if (failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);
        if (isAtOrigin || getPath(grid, failedPoints, row - 1, col, path) ||
                getPath(grid, failedPoints, row, col - 1, path))  {
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }
}
