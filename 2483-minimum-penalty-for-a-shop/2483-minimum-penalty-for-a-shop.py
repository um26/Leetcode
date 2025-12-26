class Solution:
    def bestClosingTime(self, customers: str) -> int:
        curr_pen = customers.count('Y')
        best_pen = curr_pen
        best_hr = 0

        for hr, c in enumerate(customers):
            if c == 'Y':
                curr_pen -= 1
            else: 
                curr_pen += 1
            if curr_pen < best_pen:
                best_pen = curr_pen
                best_hr = hr + 1

        return best_hr