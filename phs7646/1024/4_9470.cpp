#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int T; cin >> T;
    for(int t = 1;t <= T;t++) {
        int K,M,P; cin >> K >> M >> P;
        vector<vector<int>> aheads(M+1);
        vector<vector<int>> tails(M+1);
        vector<int> degree(M+1);
        vector<int> Strahler(M+1);
        //input
        for(int i = 0;i < P;i++) {
            int a,b; cin >> a >> b;
            tails[a].emplace_back(b);
            aheads[b].emplace_back(a);
            degree[b]++;
        }
        //build q
        queue<int> q;
        for(int i = 1;i <= M;i++) if(degree[i] == 0) {
            Strahler[i] = 1;
            q.emplace(i);
        }
        while(!q.empty()) {
            int cur = q.front(); q.pop();
            //tails의 degree 낮추기
            for(int next : tails[cur]) {
                degree[next]--;
                if(degree[next] == 0) {
                    //next의 순서 결정하고 q에 push
                    int _max = 0;
                    int _max_cnt = 0;
                    for(int prev : aheads[next]) {
                        if(_max == Strahler[prev]) _max_cnt++;
                        else if(_max < Strahler[prev]) {
                            _max = Strahler[prev];
                            _max_cnt = 1;
                        }
                    }
                    if(_max_cnt == 1) Strahler[next] = _max;
                    else Strahler[next] = _max+1;
                    q.emplace(next);
                }
            } 
        }
        cout << t << ' ' << Strahler[M] << '\n';
    }
    return 0;
}