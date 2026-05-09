
class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        layers = min(m, n) // 2

        for layer in range(layers):
            top, bottom = layer, m - 1 - layer
            left, right = layer, n - 1 - layer

            # Extract the current layer in clockwise order
            ring = []
            # top row: left to right
            for c in range(left, right + 1):
                ring.append(grid[top][c])
            # right column: top+1 to bottom
            for r in range(top + 1, bottom + 1):
                ring.append(grid[r][right])
            # bottom row: right-1 to left (if bottom != top)
            if bottom > top:
                for c in range(right - 1, left - 1, -1):
                    ring.append(grid[bottom][c])
            # left column: bottom-1 to top+1 (if left != right)
            if left < right:
                for r in range(bottom - 1, top, -1):
                    ring.append(grid[r][left])

            # Rotate the ring counter‑clockwise by k steps
            # A counter‑clockwise rotation corresponds to a left shift of the clockwise‑extracted list
            k_eff = k % len(ring)
            ring = ring[k_eff:] + ring[:k_eff]

            # Write the rotated ring back to the grid
            idx = 0
            # top row
            for c in range(left, right + 1):
                grid[top][c] = ring[idx]
                idx += 1
            # right column
            for r in range(top + 1, bottom + 1):
                grid[r][right] = ring[idx]
                idx += 1
            # bottom row
            if bottom > top:
                for c in range(right - 1, left - 1, -1):
                    grid[bottom][c] = ring[idx]
                    idx += 1
            # left column
            if left < right:
                for r in range(bottom - 1, top, -1):
                    grid[r][left] = ring[idx]
                    idx += 1

        return grid