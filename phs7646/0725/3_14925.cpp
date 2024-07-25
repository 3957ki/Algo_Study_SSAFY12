#include<iostream>

using namespace std;

bool board[1000][1000];
int dp[1000][1000]; //dp[i][j] : i,j를 우측하단 점으로해서 그릴 수 있는 최대 정사각형
int main() {
    int N,M; cin >> N >> M;
    int answer = 0;
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            int a; cin>> a;
            if(a != 0) board[i][j] = true;
            else {
                dp[i][j] = 1;
                answer = 1;
            }
        }
    }
    
    for(int i = 1;i < N;i++) {
        for(int j = 1;j < M;j++) {
            if(board[i][j]) continue;
            //dp[i][j]를 계산
            dp[i][j] = min(dp[i-1][j],dp[i][j-1]);
            dp[i][j] = min(dp[i][j],dp[i-1][j-1]) + 1;
            answer = max(answer,dp[i][j]);
        }
    }
    cout << answer;

    return 0;
}