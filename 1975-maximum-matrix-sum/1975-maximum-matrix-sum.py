class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        R, C = len(matrix), len(matrix[0])
        s = 0
        min_num = float('inf')
        num_minus = 0
        for r in range(R):
            for c in range(C):
                if matrix[r][c] < 0:
                    num_minus += 1
                val = abs(matrix[r][c])
                min_num = min(val, min_num)
                s += val
        return s if num_minus & 1 == 0 else s - (2 * min_num)
        