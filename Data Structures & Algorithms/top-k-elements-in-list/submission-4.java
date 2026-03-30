class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // index: freq; value: List<Integer> store all freq num
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int num: map.keySet()) {
            int freq = map.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] == null) continue;
            for(int b: buckets[i]) {
                res[idx++] = b;
                if (idx == k) break;
            }
        }
        return res;

    }
}

