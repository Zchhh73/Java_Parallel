package chap01;

public class ThreadLocalTest02 {

    //创建ThreadLocal对象
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello zchhh");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread: " + threadLocal.get());
            }
        });

        thread.start();

        System.out.println("main:"+threadLocal.get());
    }
}
