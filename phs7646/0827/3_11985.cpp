#include<iostream>
#include<algorithm>
#include<climits>
using namespace std;

#define MAX 20000

long long A[MAX];
long long dp[MAX];
int main() {
    int N,M,K; cin >> N >> M >> K;
    for(int i = 0;i < N;i++) cin >> A[i];

    //dp[i] = i번째를 마지막으로 포장했을 때 최소비용
    //dp[i] = for j in 0..i : dp[j] + cost(j..i)   : O(N*M)
    dp[0] = K; //single
    for(int i = 1;i < N;i++) {
        //calculate dp[i]
        dp[i] = dp[i-1] + K; //single
        int minj = max(0,i-M+1);
        long long minV = A[i];
        long long maxV = A[i];
        for(int j = i-1;j >= minj;j--) {
            //pack i to j + dp[j-1]
            //add A[j] to minV and maxV
            minV = min(minV,A[j]);
            maxV = max(maxV,A[j]);
            //update cost
            
            dp[i] = min(dp[i],(j >= 0 ?dp[j-1] : 0) + K+(i-j+1)*(maxV-minV));
        }
    }
    cout << dp[N-1];
    // for(int i = 0;i < N;i++) cout << dp[i] << " ";
    
    return 0;
}