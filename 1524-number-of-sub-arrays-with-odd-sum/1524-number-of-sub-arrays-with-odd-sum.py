class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:

        n = len(arr) + 1
        odd = sum(accumulate(arr, lambda x, y: (x+y)%2, initial = 0))
        
        return odd * (n - odd) % 1_000_000_007