class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0;
        boolean upward = true;

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];

            if (upward) {
                if (col == n - 1) {
                    row++;
                    upward = false;
                } else if (row == 0) {
                    col++;
                    upward = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    col++;
                    upward = true;
                } else if (col == 0) {
                    row++;
                    upward = true;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}
