class Solution:
    def specialTriplets(self, nums: List[int]) -> int:
        mod = 1_000_000_007
        one_cnt = defaultdict(int)  # for every x  count "x"
        two_cnt = defaultdict(int)  # for every 2x count "2x x"
        res = 0                     # count "2x x 2x"

        for num in nums:
            if num in two_cnt:
                res += two_cnt[num]
            if 2 * num in one_cnt:
                two_cnt[2 * num] += one_cnt[2 * num]
            one_cnt[num] += 1

        return res % mod
