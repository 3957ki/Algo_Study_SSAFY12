#include <cstdio>
#include <algorithm>
using namespace std;


const int INF = 0x3f3f3f3f;


const int N_MAX = 100;
const int M_MAX = 1000;
const int P_MAX = 500;


int N, M, K;
int dp[P_MAX + 1][M_MAX + 2];


int cpu[N_MAX + 1];
int mem[N_MAX + 1];
int prt[N_MAX + 1];


int main(){
    scanf("%d %d %d", &N, &M, &K);
    
    for (int i = 0; i <= P_MAX; i++){
        for (int j = 0; j <= M_MAX + 1; j++){
            dp[i][j] = -INF;
        }
    }
    
    for (int i = 1; i <= N; i++){
        scanf("%d %d %d", &cpu[i], &mem[i], &prt[i]);
    }
    
    dp[0][0] = 0;


    for (int i = 1; i <= N; i++){
        for (int j = P_MAX; j >= 0; j--){
            for (int k = M_MAX + 1; k >= 0; k--){
                if (j + prt[i] > P_MAX) continue;
                if (k + cpu[i] <= M_MAX){
                    dp[j + prt[i]][k + cpu[i]] = max(dp[j + prt[i]][k + cpu[i]], dp[j][k] + mem[i]);
                }
                if (k + cpu[i] > M_MAX){
                    dp[j + prt[i]][M_MAX + 1] = max(dp[j + prt[i]][M_MAX + 1], dp[j][k] + mem[i]);
                }
            }
        }
    }
    
    int ans = -1;
    for (int i = 0; i <= P_MAX; i++){
        for (int j = M; j <= M_MAX + 1; j++){
            if (dp[i][j] >= K){
                if (ans == -1 || ans > i){
                    ans = i;
                }
            }
        }
    }
    
    printf("%d\n", ans);


    return 0;
}
출처: https://glanceyes.com/entry/BOJ-백준-20667번-크롬 [지그시:티스토리]