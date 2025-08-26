import sys
import heapq
import bisect
from collections import Counter, deque, defaultdict
from itertools import permutations, combinations
from functools import lru_cache

input = sys.stdin.readline

def bfs(i, j, visited, grid) :
    global dr, dc
    global n, m
    dq = deque([])
    dq.append((i,j))
    visited[i][j] = True
    size = 1

    while dq :
        now = dq.pop()

        for i in range(4):
            nr = now[0] + dr[i]
            nc = now[1] + dc[i]
            if nr < 0 or nr >= n or nc < 0 or nc >= m or visited[nr][nc] or grid[nr][nc] == 0: 
                continue 
            dq.append((nr,nc))
            visited[nr][nc] = True
            size+=1
    
    return size

dr = [-1,1,0,0]
dc = [0,0,-1,1]
n, m = map(int, list(input().split()))
grid = []


for i in range(n) :
    grid.append(list(map(int,input().split())))

cnt = 0
big_pic = 0
visited = [[False for _ in range(m)] for _ in range(n)]



for i in range(n) :
    for j in range(m) :
        if grid[i][j] == 0 or visited[i][j] :
            continue
        else :
            big_pic = max(big_pic, bfs(i,j, visited, grid))
            cnt += 1

print(f"{cnt}\n{big_pic}")