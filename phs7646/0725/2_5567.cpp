#include<iostream>
#include<vector>
#include<queue>
using namespace std;


int main(){
    int N,M; cin >> N >> M;
    vector<vector<int>> v(N+1);
    for(int i = 0;i < M;i++) {
        int a,b; cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    vector<bool> visited(N+1);
    visited[1] = true;
    int count = 0;
    queue<pair<int,int>> q;
    q.push({1,0});
    while(!q.empty()) {
        pair<int,int> p = q.front();
        //cout << p.first << " " << p.second << "\n";
        q.pop();
        for(int next : v[p.first]) {
            if(!visited[next]) {
                visited[next] = true;
                if(p.second == 0) q.push({next,p.second+1});
                count++;
            }
        }
    }
    cout << count;
    

    return 0;
}