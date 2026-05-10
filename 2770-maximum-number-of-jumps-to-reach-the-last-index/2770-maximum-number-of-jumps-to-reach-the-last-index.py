class Solution:
    def maximumJumps(self, nums: List[int], target: int) -> int:
        n = len(nums)
        memo = {}

        def max_jumps(idx, n, target):
            if idx >= n - 1:
                return True
            if idx in memo:
                return memo[idx]
            m = 0
            for j in range(1, n - idx):
                curr = 0
                if -target <= nums[idx + j] - nums[idx] <= target:
                    fn = max_jumps(idx + j, n, target)
                    if fn:
                        curr = 1 + fn
                    else:
                        curr = 0
                m = max(curr, m)
            memo[idx] = m
            return memo[idx]
        k = max_jumps(0, n, target)
        if k == 1:
            return -1
        return k - 1