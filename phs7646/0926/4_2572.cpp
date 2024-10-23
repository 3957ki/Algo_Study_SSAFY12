#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
typedef pair<int,char> pp;

int main() {
    //cards input
    int N; cin >> N;
    vector<char> cards(N);
    for(int i = 0;i < N;i++) cin >> cards[i];

    //graph input
    int M,K; cin >> M >> K;
    vector<vector<pp>> adj(M+1);
    for(int i = 0;i < K;i++) {
        int a,b;
        char c;
        cin >> a >> b >> c;
        adj[a].emplace_back(b,c);
        adj[b].emplace_back(a,c);
    }

    //DP initailize
    vector<vector<int>> dp(N+1,vector<int>(M+1,-1));
    //dp[i][j] : i번째 장을 소모했을 때, j위치에 있을 경우 최대 점수
    dp[0][1] = 0; //시작..
    for(int i = 1;i <= N;i++) {
        char card = cards[i-1]; //이번에 사용할 카드
        for(int pos = 1; pos <= M;pos++) {
            if(dp[i-1][pos] == -1) continue; //pos에 있을 수 없음..
            for(pp next : adj[pos]) {
                //next로 가기
                int newScore = dp[i-1][pos];
                if(next.second == card) newScore+=10;
                dp[i][next.first] = max(dp[i][next.first],newScore);
            }
        }
    }
    int answer = 0;
    for(int pos = 1;pos <= M;pos++) answer = max(answer,dp[N][pos]);
    cout << answer;
    return 0;
}