class Solution {
    public String foreignDictionary(String[] words) {
      int[] count = new int[26];
      Arrays.fill(count, -1);
      int charCount = 0;
      for(String word: words) {
        for(char a: word.toCharArray()) {
            count[a - 'a'] = 0;
        }
      }
      List<List<Integer>> graph = new ArrayList<>();
      for(int i = 0; i < 26; i++) {
        graph.add(new ArrayList<>());
      }
      for(int i = 0; i < words.length - 1; i++) {
        int j = 0;
        String cur = words[i];
        String next = words[i + 1];
        int len = Math.min(cur.length(), next.length());
        for(; j < len; j++) {
            if (cur.charAt(j) != next.charAt(j)) {
                graph.get(cur.charAt(j) - 'a').add(next.charAt(j) - 'a');
                count[next.charAt(j) - 'a']++;
                break;
            }
        }
        if (j == len && cur.length() > next.length()) {
            return "";
        }
      }
      StringBuilder sb = new StringBuilder();
      Queue<Integer> q = new LinkedList<>();
      for(int i = 0; i < 26; i++) {
        if (count[i] == 0) {
            q.offer(i);
        }
        if (count[i] >= 0) {
            charCount++;
        }
      }
      while (!q.isEmpty()) {
        int cur = q.poll();
        sb.append((char)(cur + 'a'));
        for(int neighbor: graph.get(cur)) {
            if (--count[neighbor] == 0) {
                q.offer(neighbor);
            }
        }
      }
      return sb.length() == charCount ? sb.toString() : "";
    }
}
