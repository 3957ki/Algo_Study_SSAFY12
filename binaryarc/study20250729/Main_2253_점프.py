import sys
import heapq
import bisect
from collections import Counter, deque, defaultdict
from itertools import permutations, combinations
from functools import lru_cache
import math

input = sys.stdin.readline

N, M = map(int, input().split())

# 작은 돌들을 set으로 저장 (O(1) 검색)
small_rocks = set()
for _ in range(M):
    small_rocks.add(int(input()))

# BFS를 위한 큐 초기화
# (현재 위치, 이전 점프 거리, 점프 횟수)
queue = deque([(1, 0, 0)])

# 방문 체크: visited[위치][속도] = True
visited = [[False for _ in range(250 + 1)] for _ in range(N + 1)]
visited[1][0] = True

ans = -1

while queue:
    pos, prev_jump, jumps = queue.popleft()
    
    # 목표 도달
    if pos == N:
        ans = jumps
        break
    
    # 첫 번째 점프는 반드시 1칸
    if prev_jump == 0:
        next_pos = pos + 1
        if next_pos <= N and next_pos not in small_rocks:
            if not visited[next_pos][1]:
                visited[next_pos][1] = True
                queue.append((next_pos, 1, jumps + 1))
    else:
        # 가능한 다음 점프 거리: prev_jump-1, prev_jump, prev_jump+1
        for next_jump in [prev_jump - 1, prev_jump, prev_jump + 1]:
            if next_jump >= 1:  # 점프 거리는 최소 1
                next_pos = pos + next_jump
                if next_pos <= N and next_pos not in small_rocks:
                    if next_jump < len(visited[0]) and not visited[next_pos][next_jump]:
                        visited[next_pos][next_jump] = True
                        queue.append((next_pos, next_jump, jumps + 1))

print(ans)