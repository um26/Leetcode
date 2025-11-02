class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark walls
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;
        }

        // Mark guards
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        // Directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        // Mark watched cells
        for (int[] guard : guards) {
            for (int[] dir : dirs) {
                int r = guard[0] + dir[0];
                int c = guard[1] + dir[1];

                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 1 && grid[r][c] != 2) {
                    if (grid[r][c] == 0) grid[r][c] = 3;
                    r += dir[0];
                    c += dir[1];
                }
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }

        return count;
    }
}