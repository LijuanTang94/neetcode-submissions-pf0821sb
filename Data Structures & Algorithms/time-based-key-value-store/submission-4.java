class TimeMap {
    Map<String, List<String>> vals;
    Map<String, List<Integer>> times;

    public TimeMap() {
        vals = new HashMap<>();
        times = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        vals.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        times.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        int l = 0;
        if (!times.containsKey(key)) return "";
        List<Integer> ts = times.get(key);
        int r = ts.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (ts.get(m) > timestamp) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r == -1 ? "" : vals.get(key).get(r);
    }
}
