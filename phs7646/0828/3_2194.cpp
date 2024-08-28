#include<iostream>
#include<algorithm>
#include<queue>

using namespace std;

typedef pair<int,int> pp;
pp moves[] = {{0,1},{0,-1},{1,0},{-1,0}};
int N,M,A,B,K;
bool isValid(int i,int j) {
    if(0 > i || 0 > j) return false;
    if(i+A > N || j+B > M) return false;
    return true;
}

int map[500][500];
bool canVisit[500][500];
bool visited[500][500];
int main() {
    cin >> N >> M >> A >> B >> K;
    for(int k = 0;k < K;k++) {
        int y,x; cin >> y >> x;
        y--;x--;
        //preprocess
        for(int i = max(y-A+1,0); i <= y;i++) {
            for(int j = max(x-B+1,0); j <= x;j++) {
                canVisit[i][j] = true;
            }
        }
    }
    int starty,startx;
    int goaly,goalx;
    cin >> starty >> startx >> goaly >> goalx;
    queue<pp> q;
    q.emplace(starty-1,startx-1);
    goaly--; goalx--;
    visited[starty-1][startx-1] = true;
    int dist = 1;
    while(!q.empty()) {
        int qSize = q.size();
        for(int k = 0;k < qSize;k++) {
            pp cur = q.front(); q.pop();
            for(int d = 0;d < 4;d++) {
                int ni = cur.first + moves[d].first;
                int nj = cur.second + moves[d].second;
                if(isValid(ni,nj) && !canVisit[ni][nj] && !visited[ni][nj]) {
                    if(ni == goaly && nj == goalx) {
                        cout << dist;
                        return 0;
                    }
                    visited[ni][nj] = true;
                    q.emplace(ni,nj);
                }
            }
        }
        dist++;
    }


    cout << -1;
    return 0;
}