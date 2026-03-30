class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "": return ""
        count_window = {}
        count_need ={}
        resLen = float('infinity')
        res = [-1, -1]
        for i in range(len(t)):
            count_need[t[i]] = count_need.get(t[i], 0) + 1
        need = len(count_need)
        window = 0
        l = 0
        for r in range(len(s)):
            if s[r] in count_need:
                count_window[s[r]] = count_window.get(s[r],0) + 1
                if count_window[s[r]] == count_need[s[r]]:
                    window += 1
            while window == need:
                if r - l + 1 < resLen:
                    res = [l, r]
                    resLen = r - l + 1
                if s[l] in count_need:
                    count_window[s[l]] -= 1
                    if count_window[s[l]] == count_need[s[l]] - 1:
                        window -= 1
                l += 1
        return s[res[0] : res[1] + 1] if resLen != float('infinity') else ""
