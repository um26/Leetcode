class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        row,col,res = len(grid), len(grid[0]),0

        pattern = ["4381672943816729", "9276183492761834"]

        for r in range(row-2) :
            for c in range(col-2) :
                if grid[r+1][c+1] != 5  :
                    continue
                
                if grid[r][c] % 2 != 0 :
                    continue
                
                peri = [
                    grid[r][c],grid[r][c+1],grid[r][c+2],grid[r+1][c+2],grid[r+2][c+2],grid[r+2][c+1],grid[r+2][c],grid[r+1][c]]
                
                if all(1 <= x <= 9 for x in peri) and len(set(peri)) == 8 :
                    s = "".join(map(str,peri))
                    if s in pattern[0] or s in pattern[1] :
                        res += 1
        return res