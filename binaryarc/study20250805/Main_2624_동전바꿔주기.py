import sys

input = sys.stdin.readline

T = int(input())
k = int(input())

coin = []
for _ in range(k):
    p, n = map(int, input().split())
    coin.append((p,n))

# i금액에서 j번째 동전을 썼을때 까지의 경우의수
dp = [[0 for _ in range(k+1)] for _ in range(T+1)]
for j in range(k+1) :
    dp[0][j] = 1

for i in range(1, T+1) :
    for j in range(1,k+1) :
        val, cnt = coin[j-1]
        dp[i][j] = dp[i][j-1]
        for c in range(1, cnt+1):
            if i-val*c >= 0 :
                dp[i][j] += dp[i-val*c][j-1]
            else :
                break

print(dp[T][k])