#include<iostream>
#include<unordered_map>
#include<vector>
using namespace std;
typedef long long ll;
int N;
int arr[5];
unordered_map<int,ll> dp[36][5][5]; //사용갯수,마지막구슬,마지막구슬

int _pair(vector<int>& t) {
    int ret = 0;
    for(int tmp : t) {
        ret = ret*11 + tmp;
    }
    return ret;
}
vector<int> _unpair(int t) {
    vector<int> ret(N);
    for(int i = 0;i < N;i++) {
        ret[N-i-1] = t%11;
        t /= 11;
    }
    return ret;
}
int main() {
    cin >> N;
    int sum = 0;
    for(int i = 0;i < N;i++) {
        cin >> arr[i];
        sum += arr[i];
    }
    //초기 값 (~2개까지 끼우기)
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            if(i==j) continue;
            vector<int> use(N);
            use[i]++; use[j]++;
            dp[2][i][j][_pair(use)] = 1;
        }
    }


    for(int numUse = 3; numUse <= sum; numUse++) {
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < N;j++) {
                if(i==j) continue;
                for(int k = 0;k < N;k++) {
                    if(i==k || j==k) continue;
                    //i,j 뒤에 k 붙이기!
                    for(pair<int,ll> instance : dp[numUse-1][i][j]) {
                        vector<int> use = _unpair(instance.first);
                        if(use[k] == arr[k]) continue; //이미 다씀
                        use[k]++;
                        dp[numUse][j][k][_pair(use)] += instance.second;
                    }
                    //i,j인 case 뒤에 k 끼우기
                }
            }
        }
    }

    long long answer = 0;
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            for(pair<int,ll> instance : dp[sum][i][j]) {
                answer += instance.second;
            }
        }
    }
    cout << answer;

    return 0;
}