package chap01;

public class RunTask {

    public static class RunableTask implements Runnable{

        @Override
        public void run() {
            System.out.println("我是子线程");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();

    }
}
