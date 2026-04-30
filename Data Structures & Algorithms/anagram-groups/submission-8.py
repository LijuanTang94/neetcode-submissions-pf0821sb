from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        visited = defaultdict(list)
        for s in strs:
            count = [0] * 26
            for a in s:
                count[ord(a) - ord('a')] += 1
            visited[tuple(count)].append(s)
        return list(visited.values())