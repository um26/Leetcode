class Solution:
    def generateString(self, str1: str, str2: str) -> str:
        n = len(str1)
        m = len(str2)
        L = n + m - 1
        
        ans = ['?'] * L
        
        for i in range(n):
            if str1[i] == 'T':
                for j in range(m):
                    if ans[i+j] != '?' and ans[i+j] != str2[j]:
                        return ""
                    ans[i+j] = str2[j]
                    
        F_indices = []
        for k in range(n):
            if str1[k] == 'F':
                F_indices.append(k)
                
        q_count = [0] * n
        match_count = [0] * n
        
        for k in F_indices:
            qc = 0
            mc = 0
            for j in range(m):
                if ans[k+j] == '?':
                    qc += 1
                elif ans[k+j] == str2[j]:
                    mc += 1
            q_count[k] = qc
            match_count[k] = mc
            
            if qc == 0 and mc == m:
                return ""
                
        m_minus_1 = m - 1
        left_p = 0
        right_p = 0
        num_F = len(F_indices)
        
        for idx in range(L):
            start_k = max(0, idx - m + 1)
            end_k = min(n - 1, idx)
            
            while left_p < num_F and F_indices[left_p] < start_k:
                left_p += 1
            while right_p < num_F and F_indices[right_p] <= end_k:
                right_p += 1
                
            if ans[idx] == '?':
                forbidden = set()
                for i in range(left_p, right_p):
                    k = F_indices[i]
                    if q_count[k] == 1 and match_count[k] == m_minus_1:
                        forbidden.add(str2[idx - k])
                        
                chosen_c = None
                for c_ord in range(97, 123): 
                    c = chr(c_ord)
                    if c not in forbidden:
                        chosen_c = c
                        break
                        
                if not chosen_c:
                    return ""
                    
                ans[idx] = chosen_c
                
                for i in range(left_p, right_p):
                    k = F_indices[i]
                    q_count[k] -= 1
                    if chosen_c == str2[idx - k]:
                        match_count[k] += 1
                        
        return "".join(ans)