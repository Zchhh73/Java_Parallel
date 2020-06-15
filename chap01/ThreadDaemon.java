package chap01;

public class ThreadDaemon {

    public static void main(String[] args) {

        Thread threadDaemon = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //设置为守护线程
        threadDaemon.setDaemon(true);
        threadDaemon.start();
    }
}
