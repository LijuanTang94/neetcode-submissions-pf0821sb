class LRUCache {
    Map<Integer, Node> map;
    Node pre;
    Node tail;
    int cap;
    class Node {
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        Node pre;
        Node next;
    }

    private void addNode(Node node) {
        node.pre = tail.pre;
        node.next = tail;
        node.pre.next = node;
        tail.pre = node;
    }
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        pre = new Node(-1, -1);
        tail = new Node(-1, -1);
        pre.next = tail;
        tail.pre = pre;
        cap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addNode(node);
            return;
        }
        if (map.size() == cap) {
            Node h = pre.next;
            remove(h);
            map.remove(h.key);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addNode(node);
    }
}
