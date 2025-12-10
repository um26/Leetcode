class Solution:
    def countPermutations(self, complexity: List[int]) -> int:
        n = len(complexity)
        mod = 10**9 + 7
        answer = 1

        for i in range(1, n):
            if complexity[i] <= complexity[0]:
                return 0

        for i in range(1, n):
            answer = (answer * i) % mod
        return answer