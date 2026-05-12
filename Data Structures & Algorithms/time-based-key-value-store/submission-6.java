class TimeMap {
    Map<String, List<Pair>> map;
    class Pair {
        String value;
        int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            Pair p = list.get(m);
            if (p.timestamp > timestamp) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r < 0 ? "" : list.get(r).value;
    }
}
