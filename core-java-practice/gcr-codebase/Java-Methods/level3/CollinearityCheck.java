public class CollinearityCheck {
    public static boolean areCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    public static boolean areCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return area == 0;
    }

    public static void main(String[] args) {
        int x1 = 1, y1 = 2, x2 = 2, y2 = 4, x3 = 3, y3 = 6;
        System.out.println("Points: ("+x1+","+y1+") ("+x2+","+y2+") ("+x3+","+y3+")");
        System.out.println("Collinear (slope): " + areCollinearSlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear (area): " + areCollinearArea(x1, y1, x2, y2, x3, y3));
    }
}
