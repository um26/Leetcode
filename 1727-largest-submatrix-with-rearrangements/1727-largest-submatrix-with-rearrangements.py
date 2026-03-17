class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        m,n = len(matrix),len(matrix[0])

        for i in range(1,m):
            for j in range(n):
                if matrix[i][j] != 0:
                    matrix[i][j] += matrix[i-1][j]
        result = 0
        for row in matrix:
            row.sort(reverse=True)

            for i in range(n):
                res = row[i] * (i+1)
                result = max(result,res)
        return result