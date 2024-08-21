
import itertools

# import sys
# sys.stdin = open("input.txt", "r")


N, M = map(int, input().split())

# ice = []
# for i in range(1, N+1):
#     ice.append(i)

ice = list(itertools.combinations(range(1, N+1), 3))

bad = [[0] * (N+1) for _ in range(N+1)] # N N
for k in range(M):
    x, y = map(int, input().split())
    bad[x][y] = bad[y][x] = 1

# print(bad)

count = 0
for i in ice:
    if bad[i[0]][i[1]] or bad[i[0]][i[2]] or bad[i[1]][i[2]]:   ## 두개 인덱스에 1이면 bad조합-> count 안 하고 다 0이어야 count
        continue
    count += 1


print(count)
