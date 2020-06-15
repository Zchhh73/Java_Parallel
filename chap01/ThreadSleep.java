package chap01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * sleep()时让出指定时间的执行权，但是拥有监视器资源。
 */
public class ThreadSleep {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //获得独占锁
                lock.lock();
                try{
                    System.out.println("threadA 正在睡眠");
                    Thread.sleep(10000);
                    System.out.println("ThreadA 醒了");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                try {
                    System.out.println("ThreadB 正在休眠");
                    Thread.sleep(10000);
                    System.out.println("ThreadB 醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
