from bisect import bisect_left

class Fenwick:
    def __init__(self, n):
        self.bit = [0] * (n + 1)

    def update(self, i, delta):
        while i <= len(self.bit) - 1:
            self.bit[i] += delta
            i += i & -i

    def query(self, i):
        s = 0
        while i > 0:
            s += self.bit[i]
            i -= i & -i
        return s
class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        prefix = 0
        prefixes = [0]

        for x in nums:
            prefix += 1 if x == target else -1
            prefixes.append(prefix)

        values = sorted(set(prefixes))
        bit = Fenwick(len(values))

        ans = 0

        for p in prefixes:
            idx = bisect_left(values, p) + 1

            # Count previous prefix sums < current prefix sum
            ans += bit.query(idx - 1)

            bit.update(idx, 1)

        return ans

