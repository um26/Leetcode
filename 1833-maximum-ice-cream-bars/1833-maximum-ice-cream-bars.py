class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        costs.sort()

        spend: int = 0
        bars: int = 0
        
        for cost in costs:
            spend += cost
            if spend > coins:
                break
            else:
                bars += 1

        return bars