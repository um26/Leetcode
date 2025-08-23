class Solution {
    private int[][] grid;
    private final int INF = 1 << 30;

    public int minimumSum(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        int ans = INF;

        // Case 1: Two horizontal splits
        for (int i1 = 0; i1 < m - 2; i1++) {
            for (int i2 = i1 + 1; i2 < m - 1; i2++) {
                ans = Math.min(
                    ans,
                    f(0, 0, i1, n - 1)
                    + f(i1 + 1, 0, i2, n - 1)
                    + f(i2 + 1, 0, m - 1, n - 1)
                );
            }
        }

        // Case 2: Two vertical splits
        for (int j1 = 0; j1 < n - 2; j1++) {
            for (int j2 = j1 + 1; j2 < n - 1; j2++) {
                ans = Math.min(
                    ans,
                    f(0, 0, m - 1, j1)
                    + f(0, j1 + 1, m - 1, j2)
                    + f(0, j2 + 1, m - 1, n - 1)
                );
            }
        }

        // Case 3: Horizontal, then vertical on upper or lower
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Split upper band vertically
                ans = Math.min(ans,
                    f(0, 0, i, j)
                    + f(0, j + 1, i, n - 1)
                    + f(i + 1, 0, m - 1, n - 1)
                );
                // Split lower band vertically
                ans = Math.min(ans,
                    f(0, 0, i, n - 1)
                    + f(i + 1, 0, m - 1, j)
                    + f(i + 1, j + 1, m - 1, n - 1)
                );
            }
        }

        // Case 4: Vertical, then horizontal on left or right
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m - 1; i++) {
                // Split left band horizontally
                ans = Math.min(ans,
                    f(0, 0, i, j)
                    + f(i + 1, 0, m - 1, j)
                    + f(0, j + 1, m - 1, n - 1)
                );
                // Split right band horizontally
                ans = Math.min(ans,
                    f(0, 0, m - 1, j)
                    + f(0, j + 1, i, n - 1)
                    + f(i + 1, j + 1, m - 1, n - 1)
                );
            }
        }

        return ans;
    }

    // Helper to compute minimum area covering all 1's in subgrid [r1..r2] x [c1..c2]
    private int f(int r1, int c1, int r2, int c2) {
        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    bottom = Math.max(bottom, i);
                    right = Math.max(right, j);
                }
            }
        }
        if (top > bottom) {
            return 0; // No 1's in this segment
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}
