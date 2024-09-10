#include<iostream>
#include<set>
#include<vector>
#include<queue>
#include<algorithm>
#define MAXN 100000
#define INF 1e8
using namespace std;
typedef pair<int,int> pp;

int N,M;
int A,B;
int C;
vector<pp> adj[MAXN+1];

int dijk(int max_cost) {
    // max_cost 이하의 간선만 사용해서 A -> B까지의 최소비용 구하기
    int start = A;
    int end = B;
    vector<int> dist(N+1, INF);
    dist[A] = 0; 
    priority_queue<pp, vector<pp>, greater<pp>> pq;
    pq.emplace(0, A);

    while (!pq.empty()) {
        int c = pq.top().first;
        int v = pq.top().second;
        pq.pop();
        if (c > dist[v]) continue; //visited..
        if (v == B) break;

        // 인접한 노드들을 확인
        for (pp edge : adj[v]) {
            int next_v = edge.first;
            int edge_cost = edge.second;

            if (edge_cost > max_cost) continue; //can't use..

            int new_cost = dist[v] + edge_cost;
            if (new_cost < dist[next_v]) {
                dist[next_v] = new_cost;
                pq.emplace(new_cost, next_v);
            }
        }
    }
    return dist[B];
}

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    set<int,greater<int>> costs;
    cin >> N >> M >> A >> B >> C;
    for(int m = 0;m < M;m++) {
        int a,b,c; cin >> a >> b >> c;
        adj[a].emplace_back(b,c);
        adj[b].emplace_back(a,c);
        costs.emplace(c);
    }

    int answer = -1;
    for(int cost : costs) {
        if(dijk(cost) <= C) {
            //가능! 더 진행
            answer = cost;
        } else break; //불가능
    }
    cout << answer;
    return 0;
}