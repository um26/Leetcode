class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:

        m, n = len(grid), len(grid[0])

        # Score and cost mapping
        score = {0: 0, 1: 1, 2: 2}
        cost = {0: 0, 1: 1, 2: 1}

        # dp[i][j][c] = max score at (i, j) with cost c
        dp = [[[-1] * (k + 1) for _ in range(n)] for _ in range(m)]

        start_cost = cost[grid[0][0]]
        if start_cost > k:
            return -1

        dp[0][0][start_cost] = score[grid[0][0]]

        for i in range(m):
            for j in range(n):
                for c in range(k + 1):
                    if dp[i][j][c] == -1:
                        continue

                    # Move down
                    if i + 1 < m:
                        nc = c + cost[grid[i + 1][j]]
                        if nc <= k:
                            dp[i + 1][j][nc] = max(
                                dp[i + 1][j][nc],
                                dp[i][j][c] + score[grid[i + 1][j]]
                            )

                    # Move right
                    if j + 1 < n:
                        nc = c + cost[grid[i][j + 1]]
                        if nc <= k:
                            dp[i][j + 1][nc] = max(
                                dp[i][j + 1][nc],
                                dp[i][j][c] + score[grid[i][j + 1]]
                            )

        ans = max(dp[m - 1][n - 1])
        return ans if ans != -1 else -1