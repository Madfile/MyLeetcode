import java.util.HashMap;
import java.util.Map;

class Leetcode_146_LRU_Cache {
    private int capacity;
    private DoubleLinkedList list;
    private Map<Integer, Node> cache;

    public Leetcode_146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        list = new DoubleLinkedList();
        cache = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            list.remove(node);
            list.addToTail(node);

            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            list.remove(node);
            list.addToTail(node);
        } else {
            Node node = new Node(key, value);
            if (cache.size() == capacity) {
                Node head = list.getHead();
                list.remove(head);
                //System.out.println("key: " + key + "value: " + value);
                cache.remove(head.key);
                //System.out.println("cache size: " + cache.size());
            }

            list.addToTail(node);
            cache.put(key, node);
        }
    }
}

class DoubleLinkedList {
    Node dummyHead = new Node(-1, -1);
    Node tail = dummyHead;
    int size = 0;

    public void addToTail(Node node) {
        tail.next = node;
        node.prev = tail;
        this.tail = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        if (node.next == null) {
            node.prev.next = null;
            tail = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
    }

    public Node getHead() {
        return dummyHead.next;
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node (int key, int val) {
        this.key = key;
        this.val = val;
    }
}
