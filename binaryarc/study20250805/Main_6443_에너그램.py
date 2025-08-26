import sys

input = sys.stdin.readline

def dfs(L):
    if L == len(word):
        print(''.join(res))
        return
    for i in visited :
        if visited[i] :
            visited[i] -= 1
            res.append(i)
            dfs(L+1)
            res.pop()
            visited[i] += 1

N = int(input())

for _ in range(N) :
    word = sorted(list(map(str,input().strip())))
    visited = {}
    res =[]

    for c in word :
        if c in visited :
            visited[c] += 1
        else :
            visited[c] = 1

    dfs(0)


