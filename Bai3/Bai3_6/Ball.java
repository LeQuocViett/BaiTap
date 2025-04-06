package Bai3_6;

class Ball {
    private float x, y;
    private final int radius;
    private float xDelta, yDelta;

    public Ball(float x, float y, int radius, float xDelta, float yDelta) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }
    public Ball(float x, float y, int radius, int speed, int direction) {
        this(x,y,radius,speed*(float)Math.cos(Math.toRadians(direction)),
                - speed*(float)Math.sin(Math.toRadians(direction)));
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public int getRadius() {
        return radius;
    }
    public float getXDelta() {
        return xDelta;
    }
    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }
    public float getYDelta() {
        return yDelta;
    }
    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }
    public void move() {
        x += xDelta; y += yDelta;
    }
    public void reflectHorizontal() {
        xDelta = -xDelta;
    }
    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + x + "," + y + "), speed=(" + xDelta + "," + yDelta + ")]";
    }
}
