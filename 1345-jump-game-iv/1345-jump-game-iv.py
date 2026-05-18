from collections import deque, defaultdict

class Solution:
    def minJumps(self, arr: list[int]) -> int:
        n = len(arr)
        if n <= 1:
            return 0
        
        graph = defaultdict(list)
        for i, val in enumerate(arr):
            graph[val].append(i)
            
        queue = deque([0])
        visited = {0}
        steps = 0
        
        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()
                
                if curr == n - 1:
                    return steps
                
                # Option 1: Jump to identical values
                if arr[curr] in graph: 
                    val = arr[curr]
                    for next_idx in graph[val]:
                        if next_idx not in visited:
                            if next_idx == n - 1: return steps + 1  # Short-circuit check
                            visited.add(next_idx)
                            queue.append(next_idx)
                    del graph[val]
                
                # Option 2: Move forward (i + 1)
                if curr + 1 < n and (curr + 1) not in visited:
                    if curr + 1 == n - 1: return steps + 1  # Short-circuit check
                    visited.add(curr + 1)
                    queue.append(curr + 1)
                    
                # Option 3: Move backward (i - 1)
                if curr - 1 >= 0 and (curr - 1) not in visited:
                    visited.add(curr - 1)
                    queue.append(curr - 1)
            
            steps += 1
            
        return -1