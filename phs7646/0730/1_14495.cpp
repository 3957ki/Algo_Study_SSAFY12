#include<iostream>

using namespace std;

int main() {
    int n; cin >> n;
    long long dp[117];
    dp[1] = dp[2] = dp[3] = 1;
    for(int i = 4;i <= n;i++) {
        dp[i] = dp[i-1] + dp[i-3];
    }
    cout << dp[n];
    return 0;
}