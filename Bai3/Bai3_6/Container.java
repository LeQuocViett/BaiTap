package Bai3_6;

public class Container {
    private final int x1,y1,x2,y2;

    public Container(int x1, int y1, int width, int heigth) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + width -1;
        this.y2 = y1 + heigth -1;
    }
    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public int getWidth() { return x2 - x1 + 1; }
    public int getHeight() { return y2 - y1 + 1; }

    public boolean collidesWith(Ball ball) {
        boolean collided = false;
        if (ball.getX() - ball.getRadius() <= x1 || ball.getX() + ball.getRadius() >= x2) {
            ball.reflectHorizontal();
            collided = true;
        }
        if (ball.getY() - ball.getRadius() <= y1 || ball.getY() + ball.getRadius() >= y2) {
            ball.reflectVertical();
            collided = true;
        }
        return collided;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")]";
    }
}
class TestContainer {
    public static void main(String[] args) {
        Ball ball = new Ball(50, 50, 5, 10, 30);
        Container box = new Container(0, 0, 100, 100);

        System.out.println("Container size: " + box.getWidth() + "x" + box.getHeight());

        for (int step = 0; step < 10; ++step) {
            ball.move();
            box.collidesWith(ball);
            System.out.println(ball);
        }
    }
}
