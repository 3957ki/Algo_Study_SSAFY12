#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N;
int map[102][102]; //사각형블록으로된 테두리가 있음
// 1~5 블록
int blocks[5][4] = {{2,3,1,0},
                    {1,3,0,2},
                    {3,2,0,1},
                    {2,0,3,1},
                    {2,3,0,1}};
pair<int,int> moves[] = {{-1,0},{0,1},{1,0},{0,-1}};//상우하좌
vector<pair<int,int>> portal[5];
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);


    int T; cin >> T;
    for(int t = 1;t <= T;t++) {
        //input & initialize
        for(int i = 0;i < 5;i++) portal[i].clear();
        cin >> N;
        //set border to 5
        for(int i = 0;i <= N+1;i++) {
            map[0][i] = 5;
            map[i][0] = 5;
            map[i][N+1] = 5;
            map[N+1][i] = 5;
        }
        for(int i = 1;i <= N;i++) for(int j = 1;j <= N;j++) {
            cin >> map[i][j];
            if(map[i][j] >= 6) portal[map[i][j]-6].emplace_back(i,j);
        }
        
        //logic
        int answer = 0;
        for(int i = 1;i <= N;i++) {
            for(int j = 1;j <= N;j++) {
                if(map[i][j] != 0) continue;
                for(int d = 0;d < 4;d++) {
                    int score = 0;
                    int y = i;
                    int x = j;
                    int dir = d;
                    //y,x,dir로 게임시작!
                    while(true) {
                        //이동하기
                        //cout <<"before " << y << ' ' << x <<' ' << dir << endl;
                        y += moves[dir].first;
                        x += moves[dir].second;
                        //cout <<"after "<< y << ' ' << x <<' ' << dir << endl;
                        //cout <<"current map : " << map[y][x] << endl;
                        //특수효과 처리
                        if(y == i && x == j) break; 
                        if(map[y][x] == 0) continue;
                        if(map[y][x] == -1) break;
                        if(map[y][x] <= 5) {
                            //block
                            score++;
                            dir = blocks[map[y][x]-1][dir];
                        } else {
                            //포탈.. y,x를 다른 출구로 보내기
                            int p = map[y][x] - 6;
                            if(portal[p][0].first == y && portal[p][0].second == x) {
                                y = portal[p][1].first;
                                x = portal[p][1].second;
                            } else {
                                y = portal[p][0].first;
                                x = portal[p][0].second;
                            }
                        }
                    }
                    //cout << "case end ! score : " << score << "\n";
                    answer = max(answer,score);
                }
            }
        }
        cout << '#' << t << ' ' << answer << '\n';
    }
    return 0;
}