class MyHashSet {
    List<Integer>[] arr;

    public MyHashSet() {
        arr = new List[1000];
    }
    
    public void add(int key) {
        int h = key % 1000;
        if (arr[h] == null) arr[h] = new ArrayList<>();
        if (!arr[h].contains(key)) arr[h].add(key);
    }
    
    public void remove(int key) {
        int h = key % 1000;
        if (arr[h] == null) return;
        if (arr[h].contains(key)) arr[h].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int h = key % 1000;
        if (arr[h] == null) return false;
        if (arr[h].contains(key)) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */