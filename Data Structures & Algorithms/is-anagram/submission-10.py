class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        count = [0] * 26
        for a in s:
            count[ord(a) - ord('a')] += 1
        for b in t:
            count[ord(b) - ord('a')] -= 1
        for c in count:
            if c != 0:
                return False
        return True
        