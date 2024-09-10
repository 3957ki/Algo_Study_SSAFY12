#include<iostream>
#include<string>
#include<vector>
using namespace std;
typedef pair<int,int> pp;

 

int main() {
    string magic; cin >> magic;
    int mL = magic.size();

    string b1,b2;cin >> b1; cin >> b2;
    int bL = b1.size();

    vector<vector<int>> dp(100,vector<int>(2));//dp[i][0] : i번째 천사 돌다리를 밟는 가짓수
    //step 0 build
    for(int i = 0;i < bL;i++) {
        if(b1[i] == magic[0]) dp[i][0] = 1;
        if(b2[i] == magic[0]) dp[i][1] = 1;
    }
    
    for(int step = 1;step < mL;step++) {
        //newdp에 step을 밟을 수 있는 가짓수 저장
        vector<vector<int>> newdp(100,vector<int>(2));
        for(int i = 0;i < bL;i++) {
            //천사
            if(b1[i] == magic[step]) {
                //i보다 작은 dp값 전부 합치기
                for(int j = 0;j < i;j++) {
                    newdp[i][0] += dp[j][1];
                }
            }
            //악마
            if(b2[i] == magic[step]) {
                for(int j = 0;j < i;j++) {
                    newdp[i][1] += dp[j][0];
                }
            }
        }
        dp = newdp;
    }
    int answer = 0;
    for(int i = 0;i < bL;i++) {
        answer += dp[i][0] + dp[i][1];
    }
    cout << answer;
    return 0;
}