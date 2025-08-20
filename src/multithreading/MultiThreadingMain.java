package multithreading;

public class MultiThreadingMain {

    public static void main(String[] args) throws InterruptedException {
        BattingStatisticsThread batting = new BattingStatisticsThread();

        batting.start();

        BowlingStatisticsThread bowling = new BowlingStatisticsThread();

        Thread bowlingThread = new Thread(bowling);

        bowlingThread.start();

        batting.join();
        bowlingThread.join();


        Thread t1 = new Thread(() -> {
            System.out.println("Low priority thread");
        });
        t1.setPriority(Thread.MIN_PRIORITY); // 1

        Thread t2 = new Thread(() -> {
            System.out.println("High priority thread");
        });
        t2.setPriority(Thread.MAX_PRIORITY); // 10

        // Even setting your priorities this is not guarantee that t2 thread will run first.

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
