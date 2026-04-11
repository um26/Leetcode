class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        freq = {}
        minDis = -1
        for i in range(0, len(nums)):
            if len(freq.get(nums[i], [])) == 2:
                locMin = abs(i - freq[nums[i]][0]) + abs(freq[nums[i]][0] - freq[nums[i]][1]) + abs(freq[nums[i]][1] - i)
                if minDis != -1:
                        minDis = min(minDis, locMin)
                else:
                    minDis = locMin
                freq[nums[i]] = [freq[nums[i]][1]]
            freq[nums[i]] = freq.get(nums[i], []) + [i]
        return minDis