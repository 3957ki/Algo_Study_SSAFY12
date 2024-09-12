#include<iostream>
#include<unordered_set>
#include<queue>
#define MAXN 100000
using namespace std;
int N;
unordered_set<int> us[MAXN+1];
queue<int> q;

void Fail() {
    cout << 0;
    exit(0);
}

void dfs(int pos) {
    int num = us[pos].size(); //num to visit here
    int vis = 0; //visited num

    while(vis < num) {
        //must visit child
        int next = q.front();
        if(us[pos].find(next) == us[pos].end()) {
            //next is not child of pos...
            Fail(); 
        }
        //next is child of pos!
        q.pop();
        us[next].erase(us[next].find(pos));
        dfs(next);
        vis++;
    }
}

int main() {
    cin >> N;
    
    //N-1개의 간선정보
    for(int i = 0;i < N-1;i++) {
        int a,b; cin >> a >> b;
        us[a].emplace(b);
        us[b].emplace(a);
    }

    //N개의 dfs 순서
    for(int i = 0;i < N;i++) {
        int n; cin >> n; q.emplace(n);
    }
    if(q.front() != 1) {
        cout << 0;
        return 0;
    }
    q.pop();
    dfs(1);
    cout << 1;
    return 0;
}