#include<iostream>
#include<vector>
#include<queue>
#include<string>
using namespace std;
typedef pair<int,int> pp;
pp moves[] = {{1,0},{-1,0},{0,1},{0,-1}};

int sy,sx;
int fy,fx;
int map[50][50]; //쓰레기 : 2 , 쓰레기 옆칸 : 1, 빈칸 : 0
vector<pp> visited[50][50];

int main() {
    //input
    int N,M; cin >> N >> M;
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            char c; cin >> c;
            if(c == '.') continue;
            if(c == 'g') {
                map[i][j] = 2;
                for(pp move : moves) {
                    int a = i + move.first;
                    int b = j + move.second;
                    if(0 <= a && a < N && 0 <= b && b < M && map[a][b] == 0) {
                        map[a][b] = 1;
                    }
                }
            } else if(c == 'F') {
                fy = i; fx = j;
            } else if(c == 'S') {
                sy = i; sx = j;
            }
        }
    }

    //logic 1 : bfs
    queue<pair<pp,pp>> q;
    pp start = {sy,sx};
    pp startCost = {0,map[sy][sx]};
    q.push({start,startCost});
    visited[sy][sx].push_back(startCost);
    int answer1 = 1e9;
    int answer2 = 1e9;
    while(!q.empty()) {
        pair<pp,pp> cur = q.front(); q.pop();
        pp pos = cur.first;
        pp cos = cur.second;

        for(pp move : moves) {
            int ni = pos.first + move.first;
            int nj = pos.second + move.second;
            if(0 > ni || ni >= N || 0 > nj || nj >= M) continue;
            pp newcos = {cos.first,cos.second};
            if(map[ni][nj] == 2) newcos = {cos.first+1,cos.second};
            else if(map[ni][nj] == 1) newcos = {cos.first,cos.second+1};

            if(ni == fy && nj == fx) {
                //update, no propagate
                if(newcos.first < answer1) {
                    answer1 = newcos.first;
                    answer2 = newcos.second;
                } else if(newcos.first == answer1 && newcos.second < answer2) {
                    answer2 = newcos.second;
                }
                continue;
            }

            //can newcos visit the npos?
            bool flag = true;
            for(pp record : visited[ni][nj]) {
                if(record.first <= newcos.first && record.second <= newcos.second) {
                    //완벽한 상위호환
                    flag = false;
                    break;
                }
            }
            if(flag) {
                visited[ni][nj].push_back(newcos);
                pp newpos = {ni,nj};
                q.push(make_pair(newpos,newcos));
            }
        }
    }
    if(map[sy][sx] == 1) answer2--;
    if(map[fy][fx] == 1) answer2--;
    cout << answer1 << " " << answer2;
    return 0;
}