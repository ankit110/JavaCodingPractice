package multithreading;

public class BattingStatisticsThread extends Thread {

    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("Running Batting Statistics Thread:- " + i);
        }
    }
}
