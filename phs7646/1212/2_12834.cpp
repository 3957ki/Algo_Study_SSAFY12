#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;
typedef pair<int,int> pp;
vector<vector<pp>> graph;
int V,E;
vector<int> daijk(int start) {
    //return distances from start by daijk
    vector<int> ret(V+1);
    vector<bool> visited(V+1);
    priority_queue<pp,vector<pp>,greater<pp>> pq;
    pq.emplace(0,start); // (cost,dest)
    while(!pq.empty()) {
        pp edge = pq.top(); pq.pop();
        int cost = edge.first;
        int cur = edge.second;
        if(visited[cur]) continue;
        //visit cur
        visited[cur] = true;
        for(pp nextEdge : graph[cur]) {
            int next_cost = nextEdge.first;
            int next = nextEdge.second;
            if(visited[next]) continue;
            int new_cost = cost + next_cost;
            if(ret[next] == 0 || new_cost < ret[next]) {
                ret[next] = new_cost;
                pq.emplace(new_cost,next);
            }
        }
    }
    return ret;
}
int main() {
    int N;
    cin >> N >> V >> E;
    int A,B;
    cin >> A >> B;
    vector<int> H(N);
    for(int i = 0;i < N;i++) cin >> H[i];
    graph.resize(V+1);
    for(int i = 0;i < E;i++) {
        int t1,t2,t3;
        cin >> t1 >> t2 >> t3;
        graph[t1].emplace_back(t3,t2);
        graph[t2].emplace_back(t3,t1);
    }
    vector<int> dist1 = daijk(A);
    vector<int> dist2 = daijk(B);
    int answer = 0;
    for(int i = 0;i < N;i++) {
        answer += dist1[H[i]] + dist2[H[i]];
    }
    cout << answer;
    return 0;
}