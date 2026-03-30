class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        maxArea = 0
        for i, height in enumerate(heights):
            start = i
            while stack and stack[-1][1] > height:
                index, h = stack.pop()
                maxArea = max(maxArea, h * (i - index))
                start = index
            stack.append((start, height))
        for i,h in stack:
            maxArea = max(maxArea, h *(len(heights) - i))
        return maxArea

