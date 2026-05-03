class TimeMap {
    class Pair {
        String value;
        int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Pair>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null) return "";
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m).timestamp <= timestamp) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l == 0 ? "" : list.get(l - 1).value;
    }
}
