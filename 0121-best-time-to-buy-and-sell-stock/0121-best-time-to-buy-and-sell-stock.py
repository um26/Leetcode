class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit=0
        n=len(prices)
        min=prices[0]
        max=prices[0]

        for i in range(n):
            if prices[i]<min:
                min=prices[i]
                max=prices[i]
            if prices[i]>max:
                max=prices[i]
            if(profit<max-min):
                profit=max-min

        return profit