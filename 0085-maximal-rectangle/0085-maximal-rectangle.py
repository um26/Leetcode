class Solution:
    def psee(self, arr: List[int]) -> List[int]:
        n = len(arr)
        ans=[-1]*n
        stack = []
        for i in range(n):
            while stack and arr[stack[-1]]>= arr[i]:
                stack.pop()
            if stack:
                ans[i] = stack[-1]
            stack.append(i)
        return ans

    def nse(self, arr: List[int]) -> List[int]:
        n = len(arr)
        ans=[n]*n
        stack = []
        for i in range(n-1, -1, -1):
            while stack and arr[stack[-1]]> arr[i]:
                stack.pop()
            if stack:
                ans[i] = stack[-1]
            stack.append(i)
        return ans

    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        
        arr = [0]*len(matrix[0])
        maxArea = 0

        for row in range(rows):
            cols = len(matrix[row])
            area=0
            for col in range(cols):
                if matrix[row][col]=='1':
                    arr[col]+=1
                else :
                    arr[col]=0
            pseeArray = self.psee(arr)
            nseArray = self.nse(arr)
            for i in range(cols):
                area = (nseArray[i]-pseeArray[i]-1)*arr[i]
                maxArea = max(area, maxArea)

        return maxArea

                