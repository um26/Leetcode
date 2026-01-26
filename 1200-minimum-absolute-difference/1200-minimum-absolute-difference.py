class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        n = len(arr)
        min_diff = sys.maxsize
        for i in range(1, n):
            if arr[i] - arr[i-1] < min_diff:
                min_diff = arr[i] - arr[i-1]
        res = []
        for i in range(n):
            if arr[i] - arr[i-1] == min_diff:
                res.append([arr[i-1], arr[i]])
        return res