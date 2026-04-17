class CountSquares {
    Map<String, Integer> count;
    Map<Integer, Set<Integer>> map;

    public CountSquares() {
        count = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        String temp = x + "," + y;
        count.put(temp, count.getOrDefault(temp, 0) + 1);
        map.computeIfAbsent(y, k -> new HashSet<>()).add(x);
    }
    
    public int count(int[] point) {
        int total = 0;
        int x = point[0], y = point[1];
        if (!map.containsKey(y)) return 0;
        for(int row: map.get(y)) {
            if (x == row) continue;
            int side = Math.abs(x - row);
            total += getCount(row, y) * getCount(row, y - side) * getCount(x, y - side);
            total += getCount(row, y) * getCount(row, y + side) * getCount(x, y + side);
        }
        return total;
    }

    private int getCount(int x, int y) {
        return count.getOrDefault(x + "," + y, 0);
    }
}
