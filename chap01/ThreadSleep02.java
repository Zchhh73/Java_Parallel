package chap01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * sleep()时让出指定时间的执行权，但是拥有监视器资源。
 * 当一个线程处于睡眠状态，如果另一个线程中断，会发生什么
 */
public class ThreadSleep02 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("threadA 正在睡眠");
                    Thread.sleep(10000);
                    System.out.println("ThreadA 醒了");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        threadA.start();
        Thread.sleep(2000);
        threadA.interrupt();
    }
}
