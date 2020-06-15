package chap01;

public class ThreadNotify {

    public static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException{

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadA获得资源A锁");
                    try{
                        System.out.println("threadA开始等待");
                        resourceA.wait();
                        System.out.println("threadA结束等待");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadB获得资源A锁");
                    try{
                        System.out.println("threadB开始等待");
                        resourceA.wait();
                        System.out.println("threadB结束等待");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("threadC开始运行notify()");
                    resourceA.notify();
//                    resourceA.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");



    }
}
