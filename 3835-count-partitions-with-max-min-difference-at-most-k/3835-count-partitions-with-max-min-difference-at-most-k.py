class Solution:
    def countPartitions(self, nums: List[int], k: int) -> int:
        

        n = len(nums)
        f = [1] * (n+1)
        suffix_sums = [1] * (n+2); suffix_sums[-1] = 0
        M = 10**9 + 7

        index_j = [0] * (n+1)
        j = -1
        window_max = deque()
        window_min = deque()
        for i in range(len(nums)):
            while j+1 <= n-1 and (len(window_max)==0 or max(window_max[0][0], nums[j+1]) - min(window_min[0][0], nums[j+1]) <= k):
                j += 1
                while len(window_max) > 0 and nums[j] >= window_max[-1][0]:
                    window_max.pop()
                window_max.append((nums[j], j))
                while len(window_min) > 0 and nums[j] <= window_min[-1][0]:
                    window_min.pop()
                window_min.append((nums[j], j))
            index_j[i] = j
            if window_max[0][1] <= i: window_max.popleft()
            if window_min[0][1] <= i: window_min.popleft()

        for i in range(n-1, -1, -1):
            j = index_j[i]
            f[i] = (suffix_sums[i+1] - suffix_sums[j+2]) % M
            suffix_sums[i] = (suffix_sums[i+1] + f[i]) % M
        return f[0]