class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        # Sorting in descending so that we can pick largest first
        happiness.sort(reverse = True)

        total = 0
        for i in range(k):
            # Effective happiness after i picks
            val = happiness[i] - i

            # Stopping when value becomes less than zero
            if val <= 0:
                break
            total += val
        
        return total