class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:

        n = len(strs[0])

        isValid = lambda x: all(s[x] <= s[j] for s in strs)

        dp = [1] * n

        for j in range(1, n):

            dp[j] = max((dp[x] for x in 
                         filter(isValid,range(j))), default = 0) + 1
        
        return n - max(dp)