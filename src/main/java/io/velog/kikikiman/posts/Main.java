package io.velog.kikikiman.posts;


import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int threadCount = 10;

        long startTimeStringBuilder = System.currentTimeMillis();
        testStringBuilder(threadCount);
        long endTimeStringBuilder = System.currentTimeMillis();

        long startTimeStringBuffer = System.currentTimeMillis();
        testStringBuffer(threadCount);
        long endTimeStringBuffer = System.currentTimeMillis();

        System.out.println("Time taken for StringBuilder: " + (endTimeStringBuilder - startTimeStringBuilder) + " milliseconds");
        System.out.println("Time taken for StringBuffer: " + (endTimeStringBuffer - startTimeStringBuffer) + " milliseconds");
    }

    public static void testStringBuilder(int threadCount) {
        StringBuilder sb = new StringBuilder();
        int forLength = 1000000;
        Runnable task = () -> {
            for (int i = 0; i <= forLength; i++) {
                sb.append("a");
                if(i == forLength){
                    System.out.println("Builder 마지막");
                }
            }
//            System.out.println("builder for안 종료");
        };
//        System.out.println("builder for문종료");
        runThreads(task, threadCount);
    }

    public static void testStringBuffer(int threadCount) {
        StringBuffer sb = new StringBuffer();
        int forLength = 1000000;
        Runnable task = () -> {
            for (int i = 0; i <= forLength; i++) {
                sb.append("a");
                if(i == forLength){
                    System.out.println("Buffer 마지막");
                }
            }
        };
        runThreads(task, threadCount);
    }

    public static void runThreads(Runnable task, int threadCount) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
//                System.out.println("thread : " + thread);
                thread.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}