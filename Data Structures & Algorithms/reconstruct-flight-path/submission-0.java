class Solution {
    List<String> res;
    Map<String, List<String>> graph;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        graph = new HashMap<>();
        for(List<String> ticket: tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new LinkedList<>()).add(ticket.get(1));
        }
        for(List<String> list: graph.values()) {
            Collections.sort(list);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }
    private void dfs(String cur) {
        List<String> neighbors = graph.get(cur);
        while (neighbors != null && neighbors.size() > 0) {
            String nxt = neighbors.removeFirst();
            dfs(nxt);
        }
        res.add(cur);
    }
 }
