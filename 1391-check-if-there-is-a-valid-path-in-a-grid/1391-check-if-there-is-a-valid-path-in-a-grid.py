class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        dirs = {1: [(0,-1),(0,1)],   2: [(-1,0),(1,0)],
                3: [(0,-1),(1,0)],   4: [(0,1), (1,0)],
                5: [(-1,0),(0,-1)],  6: [(-1,0),(0,1)]}
        next = {(0,-1): {1,4,6}, (0,1): {1,3,5},
                (-1,0): {2,3,4}, (1,0): {2,5,6}}

        def DFS(icur,jcur,iprv,jprv,depth,m,n):
            if  icur==jcur==0 and depth: return False #Prevent cycle
            if  icur==m  and  jcur==n:   return True
            for di,dj in dirs[grid[icur][jcur]]:
                ni,nj = icur+di, jcur+dj
                if  0 <= ni <= m and 0 <= nj <= n and \
                    (ni,nj) != (iprv,jprv)        and \
                    grid[ni][nj] in next[(di,dj)] and \
                    DFS(ni,nj,icur,jcur,depth+1,m,n):
                    return True
            return  False
        
        return  DFS(0,0,-1,-1, 0, len(grid)-1, len(grid[0])-1)