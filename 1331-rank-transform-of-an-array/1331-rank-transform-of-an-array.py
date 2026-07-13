class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        sorted_ele = []
        ranked = list()
        dictList = dict()
        for num in arr:
            sorted_ele.append(num)
        sorted_ele.sort()
        counter = 1
        for num in sorted_ele:
            if num not in dictList:
                dictList[num] = counter
                counter+=1
        for num in arr:
            ranked.append(dictList[num])
        return ranked