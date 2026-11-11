class Solution:
    def minimumCost(self, cost1: int, cost2: int, costBoth: int,
                    need1: int, need2: int) -> int:

        # Strategy 1: Use common items only for shared requirements
        cost_a = (
            min(need1, need2) * costBoth
            + max(0, need1 - need2) * cost1
            + max(0, need2 - need1) * cost2
        )

        # Strategy 2: Buy enough common items for both requirements
        cost_b = max(need1, need2) * costBoth

        # Strategy 3: Buy individual items only
        cost_c = need1 * cost1 + need2 * cost2

        return min(cost_a, cost_b, cost_c)