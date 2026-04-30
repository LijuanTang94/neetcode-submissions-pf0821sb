class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        visited = {}
        for i, num in enumerate(nums):
            complement = target - num
            if complement in visited:
                return [visited.get(complement), i]
            visited[num] = i
        return [-1, -1]