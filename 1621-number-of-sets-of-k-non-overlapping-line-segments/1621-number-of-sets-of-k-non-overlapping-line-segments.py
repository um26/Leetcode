class Solution:
    def numberOfSets(self, n: int, k: int) -> int:
        MOD = 10**9 + 7

        # C(n + k - 1, 2k)
        N = n + k - 1
        R = 2 * k

        result = 1

        for i in range(1, R + 1):
            result = result * (N - R + i) % MOD
            result = result * pow(i, MOD - 2, MOD) % MOD

        return result