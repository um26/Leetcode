class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        counter = Counter(nums)
        maxLen = 0
        if counter[1]>0:
            if counter[1]%2 == 0 :
                maxLen = counter[1]-1
            else:
                maxLen = counter[1]
                
        for num in counter.keys():
            if num == 1:
                continue
            currNum = num
            currLen = 0
            while currNum in counter and counter[currNum]>=2:
                currLen+=2
                currNum = currNum * currNum
            if counter[currNum]==1:
                currLen+=1
            else:
                currLen-=1
            maxLen = max(maxLen,currLen)
        return maxLen          