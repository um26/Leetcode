class Solution:
    def canAliceWin(self, n: int) -> bool:
        
        def solve(t,r):
            if r > t:
                return False
            
            bob = solve(t-r,r-1)

            if bob == True:
                return False
            
            else:
                return True
        
        return solve(n,10)