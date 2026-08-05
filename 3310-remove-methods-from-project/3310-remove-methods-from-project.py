class Solution:
    def remainingMethods(self, n: int, k: int, invocations: List[List[int]]) -> List[int]:
        adj=defaultdict(list)
        for u,v in invocations:
            adj[u].append(v)
        visited=[0]*n
        def f(nei):
            visited[nei]=1
            for i in adj[nei]:
                if not visited[i]:
                    f(i)
            return
        f(k)
        res=[]
        for u,v in invocations:
            if not visited[u] and visited[v]:
                return [i for i in range(n)]
        for i in range(n):
            if visited[i]==0:
                res.append(i)
        return res
    
        