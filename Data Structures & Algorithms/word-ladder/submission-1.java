class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        if (beginWord.length() != endWord.length()) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                String cur = q.poll();
                char[] arr = cur.toCharArray();
                for(int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for(char a = 'a'; a <= 'z'; a++) {
                        if (old == a) continue;
                        arr[i] = a;
                        String newString = new String(arr);
                        if (set.contains(newString)) {
                            if (newString.equals(endWord)) {
                                return step + 1;
                            }
                            q.offer(newString);
                            set.remove(newString);
                        }
                    }
                    arr[i] = old;
                }
            }
            step++;
        }
        return 0;
    }
}
