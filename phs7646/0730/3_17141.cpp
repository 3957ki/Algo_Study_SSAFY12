#include<iostream>
#include<queue>
#define debug 0
using namespace std;
int N,M;
int map[50][50];
int selected[50][50]; //-2 벽 -1 빈공간 0 바이러스 위치
int board[50][50];
int answer = -1;
pair<int,int> moves[] = {{0,1},{1,0},{-1,0},{0,-1}};
pair<int,int> next(pair<int,int> p) {
    p.second++;
    if(p.second == N) {
        p.first++;
        p.second = 0;
    }
    return p;
}
int bfs() {
    //현재 board에서 bfs를 진행하고 최소시간 리턴
    queue<pair<int,int>> q;
    //최초 바이러스 추가
    for(int i = 0;i < N;i++) for(int j = 0;j < N;j++) if(board[i][j] == 0) q.push({i,j});
    //bfs
    while(!q.empty()) {
        pair<int,int> p = q.front(); q.pop();
        for(int m = 0;m < 4;m++) {
            int y = p.first + moves[m].first;
            int x = p.second + moves[m].second;
            if(0 <= y && y < N && 0 <= x && x < N && board[y][x] == -1) {
                board[y][x] = 1 + board[p.first][p.second];
                //if(debug) cout << p.first << " " << p.second << " " << "에서 " << y << " " << x << "로 전파 : "<< board[y][x] <<"\n";
                q.push({y,x});
            }
        }
    }
    //결과값 조사
    int ret = 0;
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            if(board[i][j] == -1) return -1;
            ret = max(ret,board[i][j]);
        }
    }

    return ret;
}
void dfs(pair<int,int> point,int count) {
    if(count == M) {
        //board로 복사
        for(int i = 0;i < N;i++) for(int j = 0;j < N;j++) board[i][j] = selected[i][j];
        //bfs로 현재상태 최소시간 계산
        int time = bfs();
        if(debug) {
            cout << "Current board\n";
            for(int i = 0;i < N;i++) {
                for(int j = 0;j < N;j++) {
                    cout << selected[i][j] << " ";
                }
                cout << endl;
            }
            cout << "After bfs\n";
            for(int i = 0;i < N;i++) {
                for(int j = 0;j < N;j++) {
                    cout << board[i][j] << " ";
                }
                cout << endl;
            }
            cout << "Time : " << time << endl;
        }
        if(time == -1) return;
        if(answer == -1 || time < answer) answer = time;
        return;
    }
    //dfs로 point 고르기
    while(point.first < N) {
        if(map[point.first][point.second] == 2) {
            //select point
            selected[point.first][point.second] = 0;
            dfs(next(point),count+1);
            //unselect point
            selected[point.first][point.second] = -1;
        }
        point = next(point);
    }
}
int main() {
    cin >> N >> M;
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            cin >> map[i][j];
            if(map[i][j] == 1) selected[i][j] = -2;
            else selected[i][j] = -1;
        }
    }
    dfs({0,0},0);
    cout << answer;
    return 0;
}