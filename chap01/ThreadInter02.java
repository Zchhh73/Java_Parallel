package chap01;

/**
 * 子线程等待特定条件的到来。使用interrupt强制sleep()抛出异常
 * 使线程从阻塞恢复到激活状态。
 */
public class ThreadInter02 {

    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadOne 睡了2000秒");
                    Thread.sleep(200000);
                    System.out.println("threadOne 醒了");
                } catch (InterruptedException e) {
                    System.out.println("threadOne 被打断仍睡");
                    return;
                }
                System.out.println("threadOne 正常结束");
            }
        });

        threadOne.start();
        Thread.sleep(1000);
        threadOne.interrupt();

        threadOne.join();
        System.out.println("main is over");


    }
}
