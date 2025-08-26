import sys
import heapq
import bisect
from collections import Counter, deque, defaultdict
from itertools import permutations, combinations
from functools import lru_cache
import math

class node :
    def __init__(self, A, B):
        self.A = A
        self.B = B

    def __lt__(self, other):
        return abs(other.A - other.B) <= abs(self.A - self.B)
        
    def __str__(self):
        return str(f"A : {self.A} B : {self.B}")

input = sys.stdin.readline
N, X = map(int,input().split())
pq =[]
ans = 0

for _ in range(N) :
    temp = list(map(int,input().split()))
    heapq.heappush(pq, node(temp[0],temp[1]))

while pq :
    now = heapq.heappop(pq)
    # print(now)
    # A 사먹을 수 있으면서 A가 더 클경우
    if ((X - 5000) >= (len(pq) * 1000)) and now.A > now.B :
        X -= 5000
        ans += now.A
    else :
        X -= 1000
        ans += now.B

print(f"{ans}")