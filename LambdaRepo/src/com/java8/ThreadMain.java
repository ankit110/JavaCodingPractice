package com.java8;

public class ThreadMain {

    public static void main(String[] args) {

        Runnable Thread1 = () -> {

            for(int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(Thread1);
        t1.setName("Ankit");
        t1.start();

        Runnable Thread2 = () -> {
            try {
                for(int i = 1; i < 10; i++) {
                    System.out.println(2*i);
                    Thread.sleep(2000);
                }
            } catch(InterruptedException exception) {
                exception.printStackTrace();
            }
        };

        Thread t2 = new Thread(Thread2);

        t2.start();
    }
}
