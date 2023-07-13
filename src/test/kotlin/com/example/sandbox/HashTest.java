package com.example.sandbox;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class HashTest {

    private static final Logger logger = LoggerFactory.getLogger(HashTest.class);

    @Test
    void test_01() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        logger.info("map " + map);
    }

    @Test
    void test_02() {
        Map<Data, Data> map = new HashMap<>();
        Data data1 = new Data(1, "name1");
        Data data2 = new Data(2, "name2");
        map.put(data1, data1);
        map.put(data2, data2);
        logger.info("map " + map);
    }

    @Test
    void test_03() {
        String[] strs = new String[5];
        strs[0] = "some string";
        logger.info("init length " + strs.length);
        String[] strings = Arrays.copyOf(strs, 10);
        logger.info("after length " + strings.length);
    }

    @Test
    void test_04() {
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        set.add("1");
        set.add("2");
        set.add("3");
        logger.info(set.toString());
    }

    @Test
    void test_05() {
        Set<String> set = new LinkedHashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        ((LinkedList<String>) set).removeFirst();

        logger.info(set.toString());
    }

    @Test
    void test_06() {
        Object o = 1;
        logger.info("class " + o.getClass());
        int[] arr = new int[1];
        int[] arr1 = {1, 2, 3};
        logger.info("arr1 " + Arrays.toString(arr1));

        logger.info("arrayList " + new ArrayList<>());
        int a = 5 >> 1;
        int b = 15 << 1;
        logger.info("bytes to right " + a);
        logger.info("bytes to left " + b);
    }

    @Test
    void test_07() {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");

        logger.info("queue " + queue.poll());
    }

    @Test
    void test_08() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");

        logger.info("queue " + queue.poll());
        logger.info("queue " + queue.poll());

        Deque<String> deque = new LinkedList<>();
        deque.offer("1");
        deque.offer("2");
        deque.offer("3");

        logger.info("queue " + deque.poll());
        logger.info("queue " + deque.poll());
    }

    @Test
    void test_09() {
        Queue<String> queue = new LinkedList<>();
        logger.info("queue " + queue.peek());
    }

    @Test
    void test_10() {
        Deque<String> deque = new LinkedList<>();
        deque.offer("1");
        deque.offer("2");
        deque.offer("3");
        logger.info("queue " + deque.pollLast());
        logger.info("queue " + deque);
    }

    @Test
    void test_11() {
        int i = 1 << 30;
        logger.info("i = " + i);
    }

    @Test
    void test_12() {
        Map<String, String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("tree", "3");
//        logger.info("i = " + map);
//        logger.info("i = " + map.entrySet());
        map.get("tree");

        map.entrySet().forEach(
                e -> {
                    logger.info("e is " + e);
                    logger.info("e hashCode is " + e.hashCode());
                    logger.info("e " + hash(e.getKey()));
                }
        );

        //System.out.println(Arrays.toString(((HashMap) map).table));
    }
    @Test
    void test_13() {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 13; i++) {
            map.put(Integer.valueOf(i).toString(), i);
        }
        System.out.println("!");
    }

    @Test
    void test_00() {
        Map<String, String> map = new TreeMap<>();
//        map.
    }

    public int index(String key, int n) {
        return key.hashCode() & (n - 1);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Test
    void test_linkedHashSet() {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(1);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        set.forEach(System.out::println);
//        set.forEach(e -> set.remove(e)); // ConcurrentModificationException
    }

    @Test
    void testLinkedHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("one", "one");
        map.put("two", "two");
        map.put("three", "three");
        map.put("one", "one");

        map.forEach((key, value) -> System.out.println(key));
        map.forEach((key, value) -> System.out.println(value));
    }

    @Test
    void generateUUID() {
        System.out.println(UUID.randomUUID());
    }

    @Test
    void testByteArrayWithMap() {
        byte[] array1 = new byte[1];
        byte[] array2 = new byte[1];

        System.out.println(array1.equals(array2));
        System.out.println(array1.hashCode());
        System.out.println(array2.hashCode());
    }

}

class Data {
    private int id;
    private String name;

    public Data(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id && Objects.equals(name, data.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
