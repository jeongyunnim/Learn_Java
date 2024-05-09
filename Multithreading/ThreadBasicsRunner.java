package Multithreading;

class Task1 extends Thread {
    public void run() { // 반드시 구현해야 하는 함수
        System.out.print("\nTask1 Started");
        for (int i = 101; i < 200; i++) {
            System.out.printf(i + " ");
        }
        System.out.print("\nTask1 Done");
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.print("\nTask2 Started");
        for (int i = 201; i < 300; i++) {
            System.out.printf(i + " ");
        }
        System.out.print("\nTask2 Done");
    }
}

public class ThreadBasicsRunner {
    public static void main(String[] args) {
        //Task1
        Task1 task1 = new Task1();
        task1.setPriority(10);
        task1.start();

        //Task2
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.start();

        //Task3
        System.out.print("\nTask3 Started");
        for (int i = 301; i < 400; i++) {
            System.out.printf(i + " ");
        }
        System.out.print("\nTask3 Done");
        System.out.print("\nmain Done");
    }
}
