#include<iostream>
#include<string>
#include<vector>
#include<queue>
using namespace std;
typedef long long ll;
int N;
string s;
vector<vector<int>> adj;
vector<bool> visited;

ll answer = 0L;
ll countIn(int point) { //연결된 실내 점 수
    ll ret = 0;
    for(int next : adj[point]){
        if(s[next]=='1') ret++; 
    }
    return ret;
}

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    //tree에서 simple path는 하나뿐임
    //"연결된 실외 점들" 은 subgraph를 이룸
    //이 subgraph에 직접 연결된 "실내 점들" 은 서로간에 조건을 만족하는 경우임.
    //즉 x개가 이 subgraph에 연결되어있다면, (x-1) * x 의 경우의 수 확보
    //이후 "직접 연결된 실내 점" 쌍은 2개의 경우의 수를 가짐 
    cin >> N;
    cin >> s;
    adj.resize(N);
    visited.resize(N);
    for(int i = 0;i < N-1;i++) {
        int a,b; cin >> a >> b;
        a--;b--;
        adj[a].emplace_back(b);
        adj[b].emplace_back(a);
        if(s[a] == s[b] && s[a] == '1') {
            //실내 연결 쌍인 경우 a->b, b->a 카운트
            answer += 2;
        }
    }
    for(int i = 0;i < N;i++) {
        if(s[i] == '1') continue; //실내
        if(visited[i]) continue; //실외
        ll num = countIn(i);
        visited[i] = true;
        queue<int> q; q.emplace(i);
        while(!q.empty()) {
            int cur = q.front(); q.pop();
            for(int next : adj[cur]) {
                if(s[next] == '1') continue;
                if(visited[next]) continue;
                visited[next] = true;
                num += countIn(next);
                q.emplace(next);
            }
        }
        answer += num * (num-1);
    }

    cout << answer;
    return 0;
}
