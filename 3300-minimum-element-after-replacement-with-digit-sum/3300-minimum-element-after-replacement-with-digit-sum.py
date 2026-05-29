class Solution:
    def minElement(self, nums: List[int]) -> int:

        def digitSum(number):
            total = 0

            while number > 0:
                total += number % 10
                number //= 10

            return total

        ans = float('inf')

        for num in nums:
            ans = min(ans, digitSum(num))

        return ans