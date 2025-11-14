class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        // Step 1: Apply difference array updates
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            diff[r1][c1] += 1;
            if (r2 + 1 < n) diff[r2 + 1][c1] -= 1;
            if (c2 + 1 < n) diff[r1][c2 + 1] -= 1;
            if (r2 + 1 < n && c2 + 1 < n) diff[r2 + 1][c2 + 1] += 1;
        }

        // Step 2: Build the final matrix using prefix sums
        int[][] result = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int val = diff[r][c];
                if (r > 0) val += result[r - 1][c];
                if (c > 0) val += result[r][c - 1];
                if (r > 0 && c > 0) val -= result[r - 1][c - 1];
                result[r][c] = val;
            }
        }

        return result;
    }
}