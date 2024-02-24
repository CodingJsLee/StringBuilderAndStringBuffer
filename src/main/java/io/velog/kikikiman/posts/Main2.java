package io.velog.kikikiman.posts;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        int threadCnt = 50;

        long startTimeStringString = System.nanoTime();
        multiThreadEnvStr(threadCnt);
        long endTimeStringString = System.nanoTime();

        long startTimeStringBuilder = System.nanoTime();
        multiThreadEnvBuilder(threadCnt);
        long endTimeStringBuilder = System.nanoTime();
        long startTimeStringBuffer = System.nanoTime();
        multiThreadEnvBuffer(threadCnt);
        long endTimeStringBuffer = System.nanoTime();



        System.out.println("String       : " + (endTimeStringString - startTimeStringString) + " milliseconds");
        System.out.println("StringBuilder: " + (endTimeStringBuilder - startTimeStringBuilder) + " milliseconds");
        System.out.println("StringBuffer:  " + (endTimeStringBuffer - startTimeStringBuffer) + " milliseconds");

    }

    public static void multiThreadEnvStr(int threadCnt) {
        System.out.println("String");

        Runnable r = () -> {
            String str = "";
           for(int i = 0; i <=100000; i++ ) {
               str = str + "h";
           }
        };

        threadRun(r, threadCnt);
    }
    public static void multiThreadEnvBuilder(int threadCnt) {
        StringBuilder sb = new StringBuilder();
        System.out.println("Builder");

        Runnable r = () -> {
            for(int i=0; i<=100000;i++) {
                sb.append("h");
            }
        };
        threadRun(r ,threadCnt);
    }

    public static void multiThreadEnvBuffer(int threadCnt) {
        StringBuffer sb = new StringBuffer();
        System.out.println("Buffer");

        Runnable r = () -> {
            for(int i=0; i<=100000;i++) {
                sb.append("h");
            }
        };
        threadRun(r ,threadCnt);
    }

    private static void threadRun(Runnable r, int threadCnt) {

        List<Thread> list = new ArrayList<>();

        for(int i= 0 ; i < threadCnt; i++) {
            Thread t = new Thread(r);
            System.out.println(t.getName() + " 쓰레드 시작");
            list.add(t);
            t.start();
        }

        for (Thread thread : list) {
            try {
                thread.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}



