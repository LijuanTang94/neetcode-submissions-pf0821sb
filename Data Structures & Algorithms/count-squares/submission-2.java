class CountSquares {
    Map<String, Integer> map;
    List<int[]> list;
    public CountSquares() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        String key = x + "," + y;
        if (!map.containsKey(key)) {
            list.add(point);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int px = point[0], py = point[1];
        int total = 0;
        for(int[] p: list) {
            int x = p[0], y = p[1];
            if (Math.abs(px - x) != Math.abs(py - y)) continue;
            if (px == x || py == y) continue;
            total += getCount(x, y) * getCount(px, y) * getCount(x, py);
        }
        return total;
    }
    private int getCount(int x, int y) {
        String key = x + "," + y;
        return map.getOrDefault(key, 0);
    }
}
