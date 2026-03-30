class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        findLeft = {"}":"{","]":"[",")":"("}
        for ch in s:
            if ch not in findLeft:
                stack.append(ch)
            else:
                if not stack or stack[-1] != findLeft[ch]:
                    return False
                stack.pop()
        return not stack