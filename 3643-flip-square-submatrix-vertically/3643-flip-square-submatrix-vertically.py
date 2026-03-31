class Solution:
    def reverseSubmatrix(self, grid: List[List[int]], x: int, y: int, k: int) -> List[List[int]]:
        return [
            [grid[i][j] if not(x<=i<x+k) or not(y<=j<y+k)  else grid[(x+k-1)-(i-x)][j]
                for j in range(len(grid[0]))
            ]
            for i in range(len(grid))
        ]
        