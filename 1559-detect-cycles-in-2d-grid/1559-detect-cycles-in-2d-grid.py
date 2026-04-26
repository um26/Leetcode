class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        rows, cols = len(grid), len(grid[0])
        parent = list(range(rows * cols))
        
        def find(i):
            if parent[i] != i:
                parent[i] = find(parent[i]) # Path compression
            return parent[i]
        
        def union(i, j):
            root_i = find(i)
            root_j = find(j)
            if root_i != root_j:
                parent[root_i] = root_j
                return True # Successfully united
            else:
                return False 
        
        for r in range(rows):
            for c in range(cols):
                index = r * cols + c
                
                # Check Right Neighbor
                if c + 1 < cols and grid[r][c] == grid[r][c+1]:
                    neighbor_index = r * cols + (c + 1)
                    if not union(index, neighbor_index):
                        return True 
                
                # Check Down Neighbor
                if r + 1 < rows and grid[r][c] == grid[r+1][c]:
                    neighbor_index = (r + 1) * cols + c
                    if not union(index, neighbor_index):
                        return True 
                        
        return False