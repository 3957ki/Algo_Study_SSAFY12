#include <iostream>
#include <vector>
#include <climits>
using namespace std;

const int INF = 1000000007;
const int M_MAX = 1000;

int main() {
    int N,M,K; 
    cin >> N >> M >> K;
    
    vector<int> m(N);
    vector<int> k(N);
    vector<int> p(N);
    int sum_P = 0;

    for(int i = 0;i < N;i++) {
        cin >> m[i] >> k[i] >> p[i];
        sum_P += p[i];
    }

    vector<vector<int>> dp(sum_P + 1, vector<int>(M_MAX + 2, -INF));
    

    dp[0][0] = 0;

    for(int i = 0;i < N;i++) {
        for(int pri = sum_P; pri >= p[i];pri--) {
            for(int cpu = M_MAX + 1; cpu >= 0; cpu--) {
                dp[pri][min(cpu + m[i],M_MAX+1)] = max(dp[pri][min(cpu + m[i],M_MAX+1)], dp[pri - p[i]][cpu] + k[i]);
            }
        }
    }

    for(int pri = 0; pri <= sum_P; pri++) {
        for(int cpu = M; cpu <= M_MAX + 1; cpu++) {
            if(dp[pri][cpu] >= K) {
                cout << pri << endl;
                return 0;
            }
        }
    }

    cout << -1 << endl;
    return 0;
}
