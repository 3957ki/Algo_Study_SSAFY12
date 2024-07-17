#include<iostream>

using namespace std;

int N;
int input[10][10];
int cost[10][10];
bool visited[10][10];
int cur = 0;
int answer = 20000;

pair<int,int> delta[4] = {{1,0},{0,1},{-1,0},{0,-1}};

pair<int,int> next(pair<int,int> p) {
    p.second++;
    if(p.second == N-1) {
        p.first++;
        p.second = 1;
    }
    return p;
}

void dfs(pair<int,int> p,int picked) {
    if(picked == 3) {
        answer = min(answer,cur);
        return;
    }
    if(p.first >= N-1) return;
    while(p.first < N-1) {
        bool needcontinue = false;
        for(int i = 0;i < 4;i++) {
            if(visited[p.first+delta[i].first][p.second+delta[i].second]) {
                p = next(p);
                needcontinue = true;
                break;
            }
        }
        if(needcontinue) continue;
        //pick
        visited[p.first][p.second] = true;
        cur += cost[p.first][p.second];
        for(int i = 0;i < 4;i++) {
            visited[p.first+delta[i].first][p.second+delta[i].second] = true;
        }
        dfs(next(p),picked+1);
        cur -= cost[p.first][p.second];
        for(int i = 0;i < 4;i++) {
            visited[p.first+delta[i].first][p.second+delta[i].second] = false;
        }
        visited[p.first][p.second] = false;
        //next
        p = next(p);
    }
}
int main() {
    cin >> N;
    for(int i = 0;i < N;i++) for(int j = 0;j < N;j++) cin >> input[i][j];
    for(int i = 1;i < N-1;i++) {
        for(int j = 1;j < N-1;j++) {
            //위와 양옆을 합쳐서
            cost[i][j] = input[i][j] + input[i-1][j] + input[i+1][j] + input[i][j-1] + input[i][j+1];
        }
    }
    //겹치지 않게 cost안에서 3개를 고르는 최소 비용.. backtrack
    dfs({1,1},0);
    cout << answer;

    return 0;
}