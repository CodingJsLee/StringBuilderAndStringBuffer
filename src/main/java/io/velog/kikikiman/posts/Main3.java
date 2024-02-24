package io.velog.kikikiman.posts;

public class Main3 {

    public static void main(String[] args) {
        String hello = "헬로";
        String world = "헬로";

        String test1 = new String("헬로");
        String test2 = new String("헬로");

        System.out.println("-----------------");
        System.out.println(world == hello);
        System.out.println(test1 == hello);
        System.out.println(test1 == test2);


    }
}
