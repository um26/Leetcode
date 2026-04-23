from collections import defaultdict

class Solution:
    def distance(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0] * n
        positions = defaultdict(list)
        
        for i, num in enumerate(nums):
            positions[num].append(i)
        
        for indexes in positions.values():
            total_sum = sum(indexes)
            left_sum = 0
            right_sum = total_sum
            total_count = len(indexes)
            
            for i, idx in enumerate(indexes):
                right_sum -= idx
                result[idx] = right_sum - (total_count - i - 1) * idx + (i * idx - left_sum)
                left_sum += idx
        
        return result