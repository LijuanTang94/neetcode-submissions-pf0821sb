class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2): return False
        count_1 = [0] * 26
        count_2 = [0] * 26
        for i in range(len(s1)):
            count_1[ord(s1[i]) - ord('a')] += 1
            count_2[ord(s2[i]) - ord('a')] += 1
        match = sum(1 for i in range(26) if count_1[i] == count_2[i])
        l, r = 0, len(s1)
        while r < len(s2):
            if match == 26:
                return True
            index_r = ord(s2[r]) - ord('a')
            count_2[index_r] += 1
            if count_1[index_r] == count_2[index_r]:
                match += 1
            elif count_1[index_r] + 1 == count_2[index_r]:
                match -= 1

            index_l = ord(s2[l]) - ord('a')
            count_2[index_l] -= 1
            if count_1[index_l] == count_2[index_l]:
                match += 1
            elif count_1[index_l] - 1 == count_2[index_l]:
                match -= 1
            l += 1
            r += 1
        return match == 26  