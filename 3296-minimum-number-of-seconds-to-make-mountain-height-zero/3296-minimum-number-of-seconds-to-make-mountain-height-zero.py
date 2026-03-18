import math

class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        def max_height_reduction(worker_time, T):
            # worker_time * x*(x+1)/2 <= T
            # solve quadratic to get max x
            discriminant = 1 + 8 * T / worker_time
            return int((-1 + math.sqrt(discriminant)) / 2)

        def feasible(T):
            total = sum(max_height_reduction(w, T) for w in workerTimes)
            return total >= mountainHeight

        lo = 0
        hi = max(workerTimes) * mountainHeight * (mountainHeight + 1) // 2

        while lo < hi:
            mid = (lo + hi) // 2
            if feasible(mid):
                hi = mid
            else:
                lo = mid + 1

        return lo