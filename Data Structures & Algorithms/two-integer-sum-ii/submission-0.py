class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        nums = {}
        for i in range(len(numbers)):
            diff = target - numbers[i]
            if diff in nums:
                return [nums[diff] + 1, i + 1]
            nums[numbers[i]] = i
        return 