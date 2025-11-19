package com.lsr.problems;

import java.util.*;
import java.util.concurrent.*;

public class SyntaxCheatSheet {

    // --- Primitive Data Types ---
    int i = 10;
    double d = 2.5;
    float f = 1.1f;
    char c = 'a';
    boolean flag = true;
    long l = 100000L;
    byte b = 1;
    short s = 2;

    // --- Strings ---
    String str = "Hello";

    public static void main(String[] args) {
        // --- Arrays ---
        int[] arr = {1, 2, 3, 4};
        System.out.println("Array element: " + arr[2]);

        // --- Lists ---
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        System.out.println("List: " + list);

        // LinkedList
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);

        // --- Sets ---
        Set<Integer> hashSet = new HashSet<>(); // unordered, no duplicates
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2);
        System.out.println("HashSet: " + hashSet);

        Set<Integer> treeSet = new TreeSet<>(); // sorted
        treeSet.add(5);
        treeSet.add(3);
        System.out.println("TreeSet: " + treeSet);

        // --- Maps ---
        Map<String, Integer> hashMap = new HashMap<>(); // unordered
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        System.out.println("HashMap: " + hashMap);

        Map<String, Integer> treeMap = new TreeMap<>(); // sorted by key
        treeMap.put("x", 24);
        treeMap.put("y", 25);
        System.out.println("TreeMap: " + treeMap);

        Map<String, Integer> hashTable = new Hashtable<>(); // thread-safe, no null keys
        hashTable.put("k1", 10);
        hashTable.put("k2", 20);
        System.out.println("HashTable: " + hashTable);

        // --- Queue ---
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println("Queue poll: " + queue.poll());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(); // min-heap
        pQueue.add(5);
        pQueue.add(1);
        System.out.println("PriorityQueue poll: " + pQueue.poll());

        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("first");
        deque.addLast("last");
        System.out.println("Deque removeFirst: " + deque.removeFirst());

        // --- Stack ---
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(200);
        System.out.println("Stack pop: " + stack.pop());

        // --- Loops ---
        for (int x : arr) {
            System.out.println("Enhanced for loop value: " + x);
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.println("Classic for loop value: " + arr[j]);
        }

        int k = 0;
        while (k < 3) {
            System.out.println("While loop index: " + k);
            k++;
        }

        // --- Switch Case ---
        int choice = 2;
        switch (choice) {
            case 1: System.out.println("One"); break;
            case 2: System.out.println("Two"); break;
            default: System.out.println("Default");
        }

        // --- Iterators ---
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println("Iterator value: " + it.next());
        }

        // --- Searching ---
        // Linear Search
        int target = 3;
        for (int val : arr) {
            if (val == target) {
                System.out.println("Linear search found: " + val);
            }
        }

        // Binary Search (array must be sorted)
        int[] sortedArr = {1, 3, 5, 7, 9};
        int idx = Arrays.binarySearch(sortedArr, 7);
        System.out.println("Binary search index: " + idx);

        // --- Multithreading basics ---
        Thread t1 = new Thread(() -> {
            System.out.println("Thread running using lambda");
        });
        t1.start();

        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Thread running using Runnable");
            }
        };
        Thread t2 = new Thread(r);
        t2.start();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> System.out.println("Task executed by ExecutorService"));
        executor.shutdown();
    }
}

/*
Key differences and notes:

- HashMap vs Hashtable:
  - HashMap: not synchronized, allows null keys/values
  - Hashtable: synchronized, no null keys or values

- HashSet vs TreeSet:
  - HashSet: unordered
  - TreeSet: sorted order

- ArrayList vs LinkedList:
  - ArrayList: fast random access, slower insert/delete in middle
  - LinkedList: fast insert/delete at ends, slower random access

- Queue types:
  - LinkedList: FIFO queue
  - PriorityQueue: ordered by priority (min-heap by default)
  - Deque: double-ended queue

- Search:
  - Linear search works on unsorted data
  - Binary search works only on sorted data

- Stack: LIFO
- Queue: FIFO

- Multithreading:
  - Thread: low-level
  - Runnable: interface for task
  - ExecutorService: high-level, manages thread pool
*/
