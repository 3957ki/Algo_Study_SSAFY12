#include<iostream>

using namespace std;
typedef pair<int,int> pp;
int R,C,K;
bool wall[5][5];
int answer;
pp moves[] = {{1,0},{-1,0},{0,1},{0,-1}};

bool visited[5][5];
void dfs(int y,int x,int count) {
    if(count == K) {
        if(y == R-1 && x == C-1) answer++;
        return;
    }
    for(pp move : moves) {
        int ny = y + move.first;
        int nx = x + move.second;
        if(0 > ny || ny >= R || 0 > nx || nx >= C) continue;
        if(visited[ny][nx]) continue;
        if(wall[ny][nx]) continue;
        if(ny == R-1 && nx == C-1 && count != K-1) continue;
        visited[ny][nx] = true;
        dfs(ny,nx,count+1);
        visited[ny][nx] = false;
    }
}

int main() {
    cin >> R >> C >> K;
    for(int i = 0;i < R;i++) {
        for(int j = 0;j < C;j++) {
            char c; cin >> c;
            if(c == 'T') wall[R-i-1][j] = true;
        }
    }
    visited[0][0] = true;
    dfs(0,0,1);
    cout << answer;

    return 0;
}