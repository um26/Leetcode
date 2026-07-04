from collections import deque
class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:

        adjList = {i: [] for i in range(1,n+1)}

        for u,v,c in roads:
            adjList[u].append([v,c])
            adjList[v].append([u,c])

        q = deque([1])
        visited = [0]*(n+1)
        min_w = float('inf')
        visited[1] = 1
        while q:
            node = q.popleft()

            for nbr, cost in adjList[node]:
                min_w = min(cost, min_w)
                if visited[nbr] == 0:
                    visited[nbr] = 1
                    q.append(nbr)

        return min_w