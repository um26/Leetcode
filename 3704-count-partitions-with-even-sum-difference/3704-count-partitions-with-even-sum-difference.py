class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        total = 0

        for num in nums:
            total += num
        
        return (len(nums) - 1, 0)[total & 1]