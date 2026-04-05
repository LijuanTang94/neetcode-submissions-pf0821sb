class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word: wordList) {
            set.add(word);
        }
        if (!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.poll();
                char[] arr = cur.toCharArray();
                for(int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for(char b = 'a'; b <= 'z'; b++) {
                        if (arr[j] == b) continue;
                        arr[j] = b;
                        String newString = new String(arr);
                        if (!set.contains(newString)) continue;
                        if (newString.equals(endWord)) return step + 1;
                        set.remove(newString);
                        q.offer(newString);
                    }
                    arr[j] = old;
                }
            }
            step++;
        }
        return 0;
    }
}
