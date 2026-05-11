class MyHashMap {
    List<int[]>[] arr;
    public MyHashMap() {
        arr = new List[1000];
    }
    
    public void put(int key, int value) {
        int h = key % 1000;
        if (arr[h] == null) {
            arr[h] = new ArrayList<>();
        }
        for(int[] pair: arr[h]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        arr[h].add(new int[] {key, value});
    }
    
    public int get(int key) {
        int h = key % 1000;
        if (arr[h] != null) {
            for(int[] pair: arr[h]) {
                if (pair[0] == key) {
                    return pair[1];
                }
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = key % 1000;
        if (arr[h] != null) {
            arr[h].removeIf(pair -> pair[0] == key);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */