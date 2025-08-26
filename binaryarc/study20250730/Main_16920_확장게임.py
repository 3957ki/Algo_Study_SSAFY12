import sys
from collections import deque


input = sys.stdin.readline

N,M,P = map(int, input().split())
S = list(map(int, input().split()))
grid = [list(input().strip()) for _ in range(N)]
ans = [0] * (P+1)
q = [deque() for _ in range(P+1)]

for i in range(N):
    for j in range(M):
        if grid[i][j].isdigit():
            player = int(grid[i][j])
            q[player].append((i, j))
            ans[player] += 1

while any(q[1:]):
    for player in range(1, P+1):
        step = 0
        while q[player] and step < S[player-1]:
            for _ in range(len(q[player])):
                r, c = q[player].popleft()
                for dr, dc in [(-1,0),(1,0),(0,-1),(0,1)]:
                    nr, nc = r + dr, c + dc
                    if 0<=nr<N and 0<=nc<M and grid[nr][nc]=='.':
                        grid[nr][nc] = str(player)
                        q[player].append((nr, nc))
                        ans[player] += 1
            step += 1

print(*ans[1:])