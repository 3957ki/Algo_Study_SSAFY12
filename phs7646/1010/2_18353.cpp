#include<iostream>
#include<vector>
using namespace std;

int main() {
    int N; cin >> N;
    vector<int> arr(N);
    for(int i = 0;i < N;i++) cin >> arr[i];
    vector<int> dp(N); // dp[i] : i번째를 반드시 포함할 때 최대 길이
    dp[0] = 1;
    int answer = 1;
    for(int i = 1;i < N;i++) {
        dp[i] = 1;
        for(int j = i-1;j >= 0;j--) {
            if(arr[j] > arr[i]) dp[i] = max(dp[i],dp[j]+1);
        }
        answer = max(answer,dp[i]);
    }
    cout << N-answer;
    return 0;
}