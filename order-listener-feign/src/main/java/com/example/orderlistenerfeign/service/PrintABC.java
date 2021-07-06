package com.example.orderlistenerfeign.service;


import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    volatile int value = 0; //打印多少遍

    private int count;

    public PrintABC(int count) {
        this.count = count;
    }

    public void printABC() {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
        new Thread(new ThreadC()).start();
    }

    class ThreadA implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; i++) {
                    while (value % 3 != 0) {
                        conditionA.await();
                    }
                    System.out.print("A");
                    conditionB.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadB implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; i++) {
                    while (value % 3 != 1) {
                        conditionB.await();
                    }
                    System.out.print("B");
                    conditionC.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ThreadC implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; i++) {
                    while (value % 3 != 2) {
                        conditionC.await();
                    }
                    System.out.println("C");
                    conditionA.signal();
                    value++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        PrintABC printABC = new PrintABC(1);
//        printABC.printABC();
       /* ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put("name", "zhangsa");
        CountDownLatch countDownLatch=new CountDownLatch(1);
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();*/
//        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
//        copyOnWriteArrayList.add();
      //  System.out.println(1%3);

//        short s1=1;
//        int i = s1 + 1;
//        String a=new String();
//        System.out.println(a.length());
//        String[] b=new String[]{};
//        int length = b.length;
//        System.out.println(length);
       // new ThreadPoolExecutor(, , , , )
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(10);
        blockingQueue.add(1);
        blockingQueue.add(2);
        blockingQueue.add(3);
        blockingQueue.add(4);
        Object poll = blockingQueue.take();
        Object pol2 = blockingQueue.take();
        Object pol3 = blockingQueue.take();
        Object pol4 = blockingQueue.take();
        System.out.println(poll);
        System.out.println(pol2);
        System.out.println(pol3);
        System.out.println(pol4);

    }
}