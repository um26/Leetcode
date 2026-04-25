class Solution:
    def maxDistance(self, side: int, points: List[List[int]], k: int) -> int:
        def keyf(x,y):
            if y==0: return x
            if x==side: return side+y
            if y==side: return 3*side-x
            return 4*side-y
        data=sorted(keyf(x,y) for x,y in points)
        np = len(points)
        def dist(i,j):
            i,j = i%np, j%np
            if i>j: i,j=j,i
            return min(data[j]-data[i], data[i]+4*side-data[j])
        def feasible(x):
            nexti=[-1]*np
            start=0
            for i in range(2*np):
                while start<np and dist(start,i)>=x:
                    nexti[start]=i
                    start+=1
            for i in range(np):
                l=[i]
                while True:
                    mul,j = divmod(l[-1], np)
                    if nexti[j]<0: break
                    l.append(mul*np + nexti[j])
                    nexti[j]=-1
                for j in range(len(l)-k):
                    if l[j+k]-l[j] <= np: return True
            return False
        l,r,res = 1, side, 0
        while l<=r:
            mid=(l+r)//2
            if feasible(mid): res,l=mid,mid+1
            else: r=mid-1
        return res