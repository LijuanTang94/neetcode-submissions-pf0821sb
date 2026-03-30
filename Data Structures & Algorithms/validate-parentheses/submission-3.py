class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        char = {"}":"{",")":"(","]":"[",}
        for ch in s:
            if ch not in char:
                stack.append(ch)
            else:
                if not stack or char[ch] != stack[-1]:
                    return False
                stack.pop()
        return not stack