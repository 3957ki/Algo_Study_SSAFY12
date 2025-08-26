import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

grid = []

for i_ in range(N) :
    ip = input().strip()
    nums = [int(num) for num in ip ]
    grid.append(nums)


dq = deque([])
visited = [[False for _ in range(M)] for _ in range(N)]

dq.append((0,0,1))
visited[0][0] = True
ans = 0
while dq :
    r, c, step = dq.popleft()
    if r == N-1 and c == M -1 :
        ans = step
        break
    for dr, dc  in [(-1,0), (1,0), (0,-1), (0,1)] :
        nr, nc = r + dr, c + dc

        if nr < 0 or nr >= N or nc < 0 or nc >= M or visited[nr][nc] or grid[nr][nc] == 0:
            continue
        dq.append((nr,nc, step+1))
        visited[nr][nc] = True

print(step)