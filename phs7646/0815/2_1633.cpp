#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int B[1000];
int W[1000];
int dp[1000][16][16];//i명 까지 고려했을떄 b명, w명 뽑았을 때 최대점수
int main() {
    int index = 0;
    int a,b;
    while(cin>>a){
        cin >> b;
        B[index] = a;
        W[index] = b;
        index++;
    }
    dp[0][1][0] = B[0];
    dp[0][0][1] = W[0];

    for(int i = 1;i < index;i++) {
        //dp[idx]를 계산
        //dp[idx][0][0] = 0;
        dp[i][1][0] = B[i]; 
        dp[i][0][1] = W[i];
        for(int w = 0;w <= 15;w++) {
            for(int b = 0;b <= 15;b++) {
                dp[i][b][w] = dp[i-1][b][w]; //안채용
                if(b >= 1) dp[i][b][w] = max(dp[i][b][w],dp[i-1][b-1][w] + B[i]); //b채용
                if(w >= 1) dp[i][b][w] = max(dp[i][b][w],dp[i-1][b][w-1] + W[i]); //w채용
            }
        }
    }
    cout << dp[index-1][15][15];

    return 0;
}