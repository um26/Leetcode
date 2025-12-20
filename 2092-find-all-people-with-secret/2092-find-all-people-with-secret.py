from collections import deque, defaultdict


class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        # arrange the meetings array based on meeting time
        meetings.sort(key=lambda x: x[-1])
        knows = set([0, firstPerson])

        # create groups with same time stamps
        grouped_meetings = []
        if meetings:
            curr_time = meetings[0][2]
            curr_group = []

            for m in meetings:
                if m[2] == curr_time:
                    curr_group.append(m)
                else:
                    grouped_meetings.append(curr_group)
                    curr_time = m[2]
                    curr_group = [m]
            grouped_meetings.append(curr_group)

        # create adj list to get spread of secret at a given time
        for group in grouped_meetings:
            # Build graph for this specific time slice
            adj = defaultdict(list)
            person_in_this_group = set()

            for p1, p2, time in group:
                adj[p1].append(p2)
                adj[p2].append(p1)
                person_in_this_group.add(p1)
                person_in_this_group.add(p2)

            # Create a queue based on the meetings and check if any of them know the secret
            # Find the "sources" of the secret in this group
            q = deque()
            for person in person_in_this_group:
                if person in knows:
                    q.append(person)

            # BFS to spread the secret within this time slice
            while q:
                curr = q.popleft()
                for neigh in adj[curr]:
                    if neigh not in knows:
                        knows.add(neigh)
                        q.append(neigh)

        return list(knows)