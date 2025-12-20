class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        output: int = 0
        n: int = len(strs)
        m: int = len(strs[0])
        for j in range(m):
            prev: str = 'a'
            is_valid: bool = True
            for i in range(n):
                if strs[i][j] < prev:
                    is_valid = False
                    break
                prev = strs[i][j]
            if not is_valid: output += 1
        return output