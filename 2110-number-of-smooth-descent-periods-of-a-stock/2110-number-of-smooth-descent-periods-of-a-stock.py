class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        
        ans = 1
        left = 0 
        right = 1
        cnt = 1
        while right < len(prices):
            if prices[left] - 1 == prices[right]:
                cnt += 1
            else:
                cnt = 1
            ans += cnt
            left = right 
            right += 1
        return ans