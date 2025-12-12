class Solution:
    def countMentions(self, numberOfUsers: int, events: List[List[str]]) -> List[int]:
        ans = [0]*numberOfUsers
        online = [1]*numberOfUsers

        offlineTime = [0]*numberOfUsers
        events.sort(key = lambda x: (int(x[1]), x[0]!="OFFLINE" ))
        
        for event in events:
            msg, time, ids = event[0],event[1],event[2]
            print(msg, time, ids)
            time = int(time)
            

            if msg == "MESSAGE":
                if str(ids) == "HERE":
                    for i in range(numberOfUsers):
                        if online[i] <= time:
                            ans [i] += 1

                elif str(ids) == "ALL":
                    for i in range(numberOfUsers):
                        ans[i] += 1

                else:
                    lst = ids.split(" ")
                    for id in lst:
                        id = int(id[2:])
                        ans[id] += 1

            else:
                online[int(ids)] = int(time) + 60

        return ans