import sys
import heapq
input = sys.stdin.readline


N = int(input())
arr = [0 for _ in range(N+1)]
ans = []
pq = []
for idx, n in enumerate(map(int, input().split()), 1) :
    arr[idx] = n
    heapq.heappush(pq,(n,idx))
Q = int(input())

for _ in range(Q) :
    query = list(map(int, input().split()))
    if query[0] == 2 :
        while pq :
            val, idx = heapq.heappop(pq)
            if arr[idx] != val :
                continue
            else :
                ans.append(idx)
                heapq.heappush(pq,(val,idx))
                break
    else :
        idx, val = query[1], query[2]
        heapq.heappush(pq, (val,idx))
        arr[idx] = val
        

print(*ans,sep='\n')