class Solution:
    def calcSteps(self, nums, ref, x):
        steps = 0
        for n in nums:
            if abs(ref - n) % x != 0:
                return -1
            steps += abs(ref - n) // x
        return steps


    def minOperations(self, grid: List[List[int]], x: int) -> int:
        step1, step2 = 0, 0
        nums = list()
        for i in range(0, len(grid)):
            for j in range(0, len(grid[i])):
                nums.append(grid[i][j])
        nums.sort()
        ref1, ref2 = nums[len(nums)//2 - 1], nums[len(nums)//2] 
        step1 = self.calcSteps(nums, ref1, x)
        step2 = self.calcSteps(nums, ref2, x)
        if max(step1, step2) == -1:
            return -1
        return min(step1, step2)