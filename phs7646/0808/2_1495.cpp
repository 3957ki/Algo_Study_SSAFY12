#include<iostream>

using namespace std;

int V[50];
bool dp[50][1001]; //i번까지 연주했을때 볼륨j가 가능한가?
int main() {
    int N,S,M;
    cin >> N >> S >> M;
    for(int i = 0;i < N;i++) cin >> V[i];

    if(S+V[0] <= M) dp[0][S+V[0]] = true;
    if(S-V[0] >= 0) dp[0][S-V[0]] = true;

    for(int i = 1;i < N;i++) {
        for(int j = 0;j <= M;j++) {
            if(!dp[i-1][j]) continue;
            if(j-V[i] >= 0) dp[i][j-V[i]] = true;
            if(j+V[i] <= M) dp[i][j+V[i]] = true;
        }
    }

    for(int m = M;m >= 0;m--) {
        if(dp[N-1][m]) {
            cout << m;
            return 0;
        }
    }
    cout << -1;
    return 0;
}