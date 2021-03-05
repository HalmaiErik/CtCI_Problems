package CH7_RecursionAndDynamProg;

public class PaintFill {
    private static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static void fillPaint(int[][] screen, Point x, int fillColor) {
        fillRec(screen, x, screen[x.i][x.j], fillColor);
    }

    private static void fillRec(int[][] screen, Point x, int startColor, int fillColor) {
        if (!isInbound(screen, x) || screen[x.i][x.j] != startColor) {
            return;
        }

        screen[x.i][x.j] = fillColor;
        fillRec(screen, new Point(x.i + 1, x.j), startColor, fillColor);
        fillRec(screen, new Point(x.i - 1, x.j), startColor, fillColor);
        fillRec(screen, new Point(x.i, x.j + 1), startColor, fillColor);
        fillRec(screen, new Point(x.i, x.j - 1), startColor, fillColor);
    }

    private static boolean isInbound(int[][] screen, Point x) {
        if (x.i < 0 || x.i >= screen.length || x.j < 0 || x.j >= screen[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] screen = {
                {1, 1, 1, 1, 2},
                {1, 2, 3, 2, 2},
                {4, 2, 3, 2, 2},
                {4, 2, 2, 2, 2},
                {5, 5, 5, 5, 5}
        };

        fillPaint(screen, new Point(1, 4), 6);

        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[0].length; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}
