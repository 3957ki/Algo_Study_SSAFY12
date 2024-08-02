#include<iostream>
#include<vector>
using namespace std;

int main() {
    int N; cin >> N;
    vector<int> A(N);
    for(int i = 0;i < N;i++) cin >> A[i];
    vector<int> dp(N); //dp[i] : i번을 골랐을 때 최댓값
    dp[0] = A[0];
    int answer = dp[0];
    for(int i = 1;i < N;i++) {
        //dp[i]를 계산
        dp[i] = A[i];
        //i보다 큰 dp[j]찾기
        for(int j = i-1;j >= 0;j--) {
            if(A[j] > A[i]) {
                dp[i] = max(A[i]+dp[j],dp[i]);
            }
        }
        //answer update
        answer = max(answer,dp[i]);
    }
    cout << answer;
    return 0;
}
