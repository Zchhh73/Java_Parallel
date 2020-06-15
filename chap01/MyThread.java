package chap01;

public class MyThread{

    public static class myThread extends Thread {

        @Override
        public void run() {
            System.out.println("我是子线程");
        }
    }

    public static void main(String[] args) {
        //创建线程
        myThread thread = new myThread();
        //启动线程
        thread.start();
    }

}

