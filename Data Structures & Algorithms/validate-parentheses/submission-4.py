class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        char = {"}":"{",")":"(","]":"[",}
        for ch in s:
            if ch not in char:
                stack.append(ch)
            else:
                if not stack or stack[-1] != char[ch]:
                    return False
                stack.pop()
        return not stack