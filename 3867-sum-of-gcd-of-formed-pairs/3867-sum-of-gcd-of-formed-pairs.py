import math

class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        fg = []
        maxx = -1

        for num in nums:
            maxx = max(maxx, num)
            fg.append(math.gcd(num, maxx))

        fg.sort()

        ans = 0
        n = len(fg)

        for i in range(n // 2):
            ans += math.gcd(fg[i], fg[n - 1 - i])

        return ans