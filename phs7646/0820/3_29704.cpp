#include<iostream>
#include<vector>
using namespace std;

int main() {
    int N,T; cin >> N >> T;
    
    vector<int> dp(T+1);
    //dp[t] : t일을 소요했을때 얻을 수 있는 돈의 최댓값
    //i-1까지의 정보를 -> i값을 업데이트
    //dp[0] = 0
    //1 1000
    //dp[1] = dp[0] + 1000
    //dp[2] = dp[1] + 1000


    int sum = 0;
    for(int i = 0;i < N;i++) {
        int cost,value; cin >> cost >> value;
        sum += value;
        for(int j = T; j >= cost;j--) {
            dp[j] = max(dp[j],dp[j-cost]+value);
        }
    }
    int maxValue = dp[0];
    for(int i = 1;i <= T;i++) maxValue = max(maxValue,dp[i]);
    cout << sum - maxValue;
    
    return 0;
}