class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        visited = []
        for num in nums:
            if num in visited:
                return True
            visited.append(num)
        return False
        