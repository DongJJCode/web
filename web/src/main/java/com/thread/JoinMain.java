package com.thread;

public class JoinMain {
    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < 1000000 ; j++) {
                i ++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join();
        System.out.println(i);
    }
}
