#include<iostream>
#include<cmath>

#define MAXN 100000
using namespace std;

int dp[MAXN+1];

int main() {
    int N; cin >> N;
    
    for(int i = 1;i <= N;i++) dp[i] = i;//dp[i] = 최대 i임

    for(int i = 2;i < sqrt(N)+1;i++) {
        int mul = i*i;
        for(int j = 0;j + mul<= N;j++) {
            dp[j+mul] = min(dp[j+mul],dp[j]+1);
        }
    }

    cout << dp[N];

    return 0;
}