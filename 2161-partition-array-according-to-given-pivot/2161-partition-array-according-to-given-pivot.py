from typing import List

class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        l = eq = 0

        for i in nums:
            if i < pivot:
                l += 1
            elif i == pivot:
                eq += 1

        op = [0] * len(nums)

        li = 0
        ei = l
        gi = l + eq

        for i in nums:
            if i < pivot:
                op[li] = i
                li += 1
            elif i == pivot:
                op[ei] = i
                ei += 1
            else:
                op[gi] = i
                gi += 1

        return op