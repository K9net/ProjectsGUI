package NetworkAndThreads;

public class RunThreads implements Runnable{

    public static void main(String[] args) {
        RunThreads runner = new RunThreads();
        Thread first = new Thread(runner);
        Thread second = new Thread(runner);
        first.setName("Первый поток");
        second.setName("Второй поток");
        first.start();
        second.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println("Сейчас работает " + threadName);
        }
    }
}
