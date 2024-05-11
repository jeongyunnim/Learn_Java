package Multithreading;

class Task extends Thread {

    private int num;

    Task(int num) {
        this.num = num;
    }

    public void run() {
        System.out.printf("Task %d Started\n", num);
        for (int i = num * 100; i < num * 100 + 100; i++) {
            System.out.printf("%d ", i);
        }
        System.out.printf("\nTask %d Done\n", num);
    }
}

class Task1 extends Thread {
    public void run() { // 반드시 구현해야 하는 함수
        System.out.print("Task1 Started\n");
        for (int i = 101; i < 200; i++) {
            System.out.printf(i + " ");
        }
        System.out.print("\nTask1 Done\n");
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.print("Task2 Started\n");
        for (int i = 201; i < 300; i++) {
            System.out.printf(i + " ");
        }
        System.out.print("\nTask2 Done\n");
    }
}

public class ThreadBasicsRunner {
    public static void main(String[] args) throws InterruptedException {
        //Task1
        Task1 task1 = new Task1();
        task1.setPriority(1);
        task1.start();

        //Task2
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.setPriority(10);
        task2Thread.start();

        task1.join();

        task2Thread.join();
        //Task3
        System.out.print("Task3 Started\n");
        for (int i = 301; i < 400; i++) {
            System.out.printf(i + " ");
        }
        System.out.print("\nTask3 Done\n");
        System.out.print("\nmain Done\n");
    }
}
