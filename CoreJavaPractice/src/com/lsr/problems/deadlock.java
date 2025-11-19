package com.lsr.problems;

public class deadlock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        deadlock d = new deadlock();
        
        // Thread 1 tries to lock lock1 then lock2
        Thread t1 = new Thread(() -> d.method1(), "Thread-1");

        // Thread 2 tries to lock lock2 then lock1
        Thread t2 = new Thread(() -> d.method2(), "Thread-2");
        
        t1.start();
        t2.start();
    }

    public void method1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " locked lock1");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
 
            System.out.println(Thread.currentThread().getName() + " waiting for lock2...");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " locked lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " locked lock2");
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " waiting for lock1...");
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " locked lock1");
            }
        }
    }
}
