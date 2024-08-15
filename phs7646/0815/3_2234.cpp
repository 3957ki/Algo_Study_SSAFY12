#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int map[50][50];
pair<int,int> moves[] = {{0,-1},{-1,0},{0,1},{1,0}};
int visited[50][50];
int main() {
    int N,M; cin >> M >> N;
    
    //get input
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            cin >> map[i][j];
        }
    }

    //bfs
    int room_number = 1;
    vector<int> room_area; 
    room_area.emplace_back(0);
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            if(visited[i][j] != 0) continue;
            queue<pair<int,int>> q;
            visited[i][j] = room_number;
            room_area.emplace_back(1);
            q.emplace(i,j);
            //bfs를 하며 현재 칸을 room_number로 표기
            //현재 방의 크기는 room_area에 저장
            while(!q.empty()) {
                pair<int,int> p = q.front(); q.pop();
                int bit = map[p.first][p.second];
                for(int dir = 0;dir < 4;dir++) {
                    if((bit & (1<<dir)) == 0) {
                        //갈 수 있다
                        int y = p.first + moves[dir].first;
                        int x = p.second + moves[dir].second;
                        if(visited[y][x] == 0) {
                            visited[y][x] = room_number;
                            room_area[room_number]++;
                            q.emplace(y,x);
                        }
                    }
                }
            }
            room_number++;
        }
    }
    cout << room_number-1 << "\n";
    int max_room = 0;
    for(int area : room_area) max_room = max(max_room,area);
    cout << max_room << "\n";


    //벽 허물기. 허물면 두 방이 합쳐짐
    int answer = 0;
    //세로 오른쪽 허물기
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M-1;j++) {
            //오른쪽과 같은 방이면 continue
            if(visited[i][j] == visited[i][j+1])continue;
            //동쪽에 벽이 있다면
            if((map[i][j] & (1<<2)) != 0) {
                int room1 = room_area[visited[i][j]];
                int room2 = room_area[visited[i][j+1]];
                answer = max(answer,room1+room2);
            } 
        }
    }
    //아래벽 허물기
    for(int i = 0;i < N-1;i++) {
        for(int j = 0;j < M;j++) {
            if(visited[i][j] == visited[i+1][j]) continue;
            if((map[i][j] & (1<<3))!=0) {
                int room1 = room_area[visited[i][j]];
                int room2 = room_area[visited[i+1][j]];
                answer = max(answer,room1+room2);
            }
        }
    }
    cout << answer;
    return 0;
}