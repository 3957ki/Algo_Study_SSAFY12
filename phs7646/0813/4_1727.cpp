#include<iostream>
#include<algorithm>
#include<vector>
#include<climits>
using namespace std;

int main() {
    //input
    int N,M; cin >> N >> M;
    int numMany = max(N,M);
    int numCouple = min(N,M);
    vector<int> v1(numMany); //많은쪽
    vector<int> v2(numCouple); //적은쪽
    if(N >= M) {
        for(int i = 0;i < N;i++) cin >> v1[i];
        for(int i = 0;i < M;i++) cin >> v2[i];
    }
    else {
        for(int i = 0;i < N;i++) cin >> v2[i];
        for(int i = 0;i < M;i++) cin >> v1[i];
    }
    sort(v1.begin(),v1.end()); sort(v2.begin(),v2.end());

    //성격차이의 합의 최솟값? 
    vector<vector<long long>> dp(numMany,vector<long long>(numCouple,LLONG_MAX));
    //dp[i][j] = v1의 i번째 까지 사용해서 v2의 j번째 까지 매칭할때 성격차이의 최소
    //dp[i][c] = min(dp[i-1][c] , dp[i-1][c-1] + cost(c-i))
    //i,c가 계산되려면 i-1이 전부 계산되어야함
    dp[0][0] = abs(v1[0]-v2[0]);
    for(int i = 1;i < numMany;i++) {
        //dp[i][0]계산 : 값을 순회하며 최소 성격차이 찾기
        dp[i][0] = abs(v1[0] - v2[0]);
        for(int j = 1;j <= i;j++) dp[i][0] = min(dp[i][0],static_cast<long long>(abs(v1[j]-v2[0])));

        //dp[i][c]계산
        for(int c = 1;c <= min(i,numCouple-1);c++) {
            dp[i][c] = min(dp[i-1][c],dp[i-1][c-1] + abs(v1[i]-v2[c])); 
        }
    }
    // for(int i = 0;i < numMany;i++) {
    //     for(int c = 0;c < min(i+1,numCouple);c++) cout << dp[i][c] << " ";
    //     cout << endl;
    // }
    cout << dp[numMany-1][numCouple-1];
    return 0;
}