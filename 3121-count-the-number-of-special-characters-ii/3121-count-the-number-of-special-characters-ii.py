class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        special = {}
        
        for i, ch in enumerate(word) :
            if ch not in special :
                special[ch] = 0

            if ch.isupper() :
                if ch.lower() in special and ch not in word[:i]:
                    special[ch] += 1

            elif ch.islower() :
                if ch.upper() in special and ch in word[:word.find(ch.upper())] :
                    special[ch] = -1
                
        return sum(list(special.values()))