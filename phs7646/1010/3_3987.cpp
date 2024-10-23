#include<iostream>
#include<string>
#include<vector>
using namespace std;
typedef pair<int,int> pp;
pp moves[] = {{-1,0},{0,1},{1,0},{0,-1}};
char dname[] = {'U','R','D','L'};
string map[501];
int N,M;
bool isValid(int y,int x) {
    if(y < 0 || y >= N || x < 0 || x >= M) return false;
    return true;
}
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    cin >> N >> M;
    for(int i = 0;i < N;i++) cin >> map[i];
    int R,C; cin >> R >> C; R--; C--;

    int answerL = 0;
    int answerD = 0;

    for(int d = 0;d < 4;d++) {
        //d 방향으로 발사
        int cnt = 1;
        int dir = d;
        int y = R, x = C;
        vector<vector<vector<bool>>> visited(N,vector<vector<bool>>(M,vector<bool>(4)));
        visited[y][x][dir] = true;
        while(true) {
            int ny = y + moves[dir].first;
            int nx = x + moves[dir].second;
            if(!isValid(ny,nx)) break;
            if(map[ny][nx] == 'C') break;
            if(visited[ny][nx][dir]) {
                cout << dname[d] << "\n";
                cout << "Voyager";
                return 0;
            }
            visited[ny][nx][dir] = true;
            if(map[ny][nx] == '\\') { //URDL
                if(dir == 0) dir = 3; 
                else if(dir == 1) dir = 2;
                else if(dir == 2) dir = 1;
                else dir = 0;
            } else if(map[ny][nx] == '/') {
                if(dir == 0) dir = 1; 
                else if(dir == 1) dir = 0;
                else if(dir == 2) dir = 3;
                else dir = 2;
            }
            y = ny;
            x = nx;
            cnt++;
        }
        if(cnt > answerL) {
            answerD = d;
            answerL = cnt;
        }
    }
    cout << dname[answerD] << "\n";
    cout << answerL;
    return 0;
}