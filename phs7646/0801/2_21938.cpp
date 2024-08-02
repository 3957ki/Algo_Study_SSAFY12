#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int map[1000][1000];
pair<int,int> moves[] = {{0,1},{1,0},{-1,0},{0,-1}};
vector<vector<bool>> board;

int main() {
    int N,M; cin >> N >> M;
    board.resize(N,vector<bool>(M));
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            int a,b,c; cin >> a >> b >> c;
            map[i][j] = a+b+c;
        }
    }
    int T; cin >> T;
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            if(map[i][j] >= 3 * T) board[i][j] = true;
        }
    }

    vector<vector<bool>> visited(N,vector<bool>(M));
    int answer = 0;
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            if(visited[i][j]) continue;
            if(board[i][j]) {
                answer++;
                //bfs
                queue<pair<int,int>> q;
                q.push({i,j});
                while(!q.empty()) {
                    pair<int,int> p = q.front();
                    q.pop();
                    for(int m = 0;m < 4;m++) {
                        int new_i = p.first + moves[m].first;
                        int new_j = p.second + moves[m].second;
                        if(0 <= new_i && new_i < N && 0 <= new_j && new_j < M) {
                            if(!visited[new_i][new_j] && board[new_i][new_j]) {
                                visited[new_i][new_j]  = true;
                                q.push({new_i,new_j});
                            }
                        }
                    }
                }
            }
        }
    }
    cout << answer;

    return 0;
}