import bisect
from typing import List

class Solution:
    def maximumWeight(self, intervals: List[List[int]]) -> List[int]:
        # Bind original index and sort by start time
        arr = sorted([(s, e, w, i) for i, (s, e, w) in enumerate(intervals)])
        starts = [x[0] for x in arr]
        n = len(arr)
        
        # dp[i][c] = (best_weight, lexicographically_smallest_sequence) 
        # using at most `c` intervals from suffix arr[i:]
        dp = [[(0, []) for _ in range(5)] for _ in range(n + 1)]
        
        for i in range(n - 1, -1, -1):
            s, e, w, idx = arr[i]
            # Find the first interval that starts strictly after the current interval ends
            nxt = bisect.bisect_right(starts, e)
            
            for c in range(1, 5):
                take_w, take_seq = dp[nxt][c - 1]
                skip_w, skip_seq = dp[i + 1][c]
                
                cand_w = take_w + w
                cand_seq = sorted(take_seq + [idx])
                
                # Pick the configuration giving more weight, or tie-break lexicographically
                if cand_w > skip_w or (cand_w == skip_w and cand_seq < skip_seq):
                    dp[i][c] = (cand_w, cand_seq)
                else:
                    dp[i][c] = (skip_w, skip_seq)
                    
        # dp[0][4] implicitly contains the best setup spanning exactly up to 4 intervals overall
        return dp[0][4][1]