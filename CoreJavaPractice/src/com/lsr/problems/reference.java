package com.lsr.problems;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class reference {

    // ===== Primitive Types =====
    int i = 0;
    String s = "Hello";
    double d = 2.0;
    char c = 'a';
    boolean flag = true;
    long l = 100L;
    float f = 1.2f;

    // ===== Arrays =====
    int[] arr = {1, 2, 3};
    String[] strArr = new String[]{"a", "b", "c"};
    int[][] matrix = {{1, 2}, {3, 4}};

    // ===== Lists =====
    List<Integer> arrayList = new ArrayList<>();
    List<Integer> linkedList = new LinkedList<>();

    // ===== Sets =====
    Set<String> hashSet = new HashSet<>();
    Set<String> linkedHashSet = new LinkedHashSet<>();
    Set<String> treeSet = new TreeSet<>();

    // ===== Maps =====
    Map<Integer, String> hashMap = new HashMap<>();
    Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
    Map<Integer, String> treeMap = new TreeMap<>();
    Map<Integer, String> hashtable = new Hashtable<>();

    // ===== Queues =====
    Queue<Integer> queue = new LinkedList<>();           // FIFO
    Deque<Integer> deque = new ArrayDeque<>();           // Double-ended queue
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-heap
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    // ===== Stack =====
    Stack<Integer> stack = new Stack<>(); // LIFO

    // ===== Iterators =====
    public void iterateCollections() {
        List<String> list = Arrays.asList("a", "b", "c");
        for (String str : list) System.out.println(str);
        list.forEach(System.out::println); // lambda
        Iterator<String> it = list.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }

    // ===== Searching =====
    public int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key) return i;
        return -1;
    }

    public int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // ===== Sorting =====
    public void sortingExamples() {
        int[] arr = {5, 1, 4, 2};
        Arrays.sort(arr); // QuickSort internally for primitives
        List<Integer> list = Arrays.asList(5, 1, 4, 2);
        Collections.sort(list); // Natural order
        list.sort(Comparator.reverseOrder()); // Custom sort
    }

    // ===== Lambdas & Streams =====
    public void lambdaAndStream() {
    	Predicate<Integer> p =  t -> t>5;
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubled = nums.stream()
                                    .map(n -> n * 2)
                                    .filter(p)
                                    .collect(Collectors.toList());
        doubled.forEach(System.out::println);
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println("Sum = " + sum);
    }

    // ===== Switch Expression (Java 14+) =====
    public void newSwitch(int day) {
        String result = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid";
        };
        System.out.println(result);
    }

    // ===== Multi-threading =====
    public void multiThreading() {
        // Thread using Runnable
        Runnable task = () -> System.out.println("Thread running");
        Thread t1 = new Thread(task);
        t1.start();

        // ExecutorService
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> System.out.println("Executor thread running"));
        service.shutdown();
    }

    // ===== Synchronization =====
    public synchronized void syncMethod() {
        System.out.println("Thread-safe method");
    }

    // ===== Advanced Concurrent Collections =====
    ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    // ===== Other Features =====
    public void enhancedForLoop() {
        int[] nums = {1, 2, 3};
        for (int n : nums) System.out.println(n);
    }

    // ===== Records (Java 16+) =====
    record Person(String name, int age) {}

    // ===== Optional (Java 8+) =====
    public void optionalExample() {
        Optional<String> opt = Optional.ofNullable("Hello");
        opt.ifPresent(System.out::println);
        String val = opt.orElse("Default");
        System.out.println(val);
    }

    // ===== String operations =====
    public void stringOps() {
        String s = "Java";
        System.out.println(s.length());
        System.out.println(s.substring(1, 3));
        System.out.println(s.toUpperCase());
        System.out.println(s.equals("java"));
    }
}
