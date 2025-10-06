import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0}); // {elevation, row, col}
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int elevation = curr[0], r = curr[1], c = curr[2];
            if (r == n - 1 && c == n - 1) return elevation;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{Math.max(elevation, grid[nr][nc]), nr, nc});
                }
            }
        }
        return -1; // Should never reach here
    }
}