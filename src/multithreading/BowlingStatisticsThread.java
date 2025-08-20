package multithreading;

public class BowlingStatisticsThread implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("Running Bowling Statistics Thread:- " + i);
        }
    }
}
