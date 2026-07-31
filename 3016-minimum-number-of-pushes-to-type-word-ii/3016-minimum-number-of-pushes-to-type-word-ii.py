from collections import Counter

class Solution:
    def minimumPushes(self, word: str) -> int:
        # Count the frequency of each letter in the word
        freq = Counter(word)
        
        # Sort the frequencies in descending order
        sorted_freq = sorted(freq.values(), reverse=True)
        
        total_pushes = 0
        
        # Assign the highest frequencies to the lowest push costs
        for i, count in enumerate(sorted_freq):
            # i // 8 determines the "tier" (0 for 1st press, 1 for 2nd press, etc.)
            pushes_needed = (i // 8) + 1
            total_pushes += count * pushes_needed
            
        return total_pushes