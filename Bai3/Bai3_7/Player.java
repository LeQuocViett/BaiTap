package Bai3_7;

import java.util.Random;

public class Player {
    private int number;
    private float x;
    private float y;
    private float z;

    public Player(int number, float x, float y, float z) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void move(float xDisp, float yDisp){
        this.x +=xDisp;
        this.y +=yDisp;
    }

    public void jump(float zDisp){
        this.z+=zDisp;
    }

    public boolean near(Ball ball){
        if(Math.sqrt(Math.pow(ball.getX() - this.x, 2) + Math.pow(ball.getY()-this.y, 2) + Math.pow(ball.getZ()-this.z, 2)) < 8){
            return true;
        }else{
            return false;
        }
    }

    public void kick(Ball ball){
        Random rand = new Random();
        ball.setX(ball.getX()+rand.nextInt(20));
        ball.setY(ball.getY()+rand.nextInt(20));
        ball.setZ(ball.getZ()+rand.nextInt(5));
    }

}