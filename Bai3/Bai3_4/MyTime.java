package Bai3_4;

public class MyTime {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public MyTime() {};

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour,minute,second);
    }

    public MyTime nextHour() {
        hour = (hour + 1) % 24;
        return this;
    }

    public MyTime nextMinute() {
        if (minute == 59) {
            minute = 0;
            nextHour();
        } else {
            minute++;
        }
        return this;
    }

    public MyTime nextSecond() {
        if (second == 59) {
            second = 0;
            nextMinute();
        } else {
            second++;
        }
        return this;
    }

    public MyTime previousHour() {
        hour = (hour == 0) ? 23 : hour - 1;
        return this;
    }

    public MyTime previousMinute() {
        if (minute == 0) {
            minute = 59;
            previousHour();
        } else {
            minute--;
        }
        return this;
    }

    public MyTime previousSecond() {
        if (second == 0) {
            second = 59;
            previousMinute();
        } else {
            second--;
        }
        return this;
    }
}

class TestMyTime {
    public static void main(String[] args) {
        MyTime myTime = new MyTime(23, 59, 59);
        System.out.println(myTime); // 23:59:59
        myTime.nextSecond();
        System.out.println(myTime); // 00:00:00
        myTime.previousSecond();
        System.out.println(myTime); // 23:59:59
    }
}

