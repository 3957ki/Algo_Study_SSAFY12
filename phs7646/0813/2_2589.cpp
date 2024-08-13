#include<iostream>
#include<string>
#include<vector>
#include<queue>
using namespace std;

int N,M;
bool map[50][50];
pair<int,int> moves[] = {{0,1},{1,0},{-1,0},{0,-1}};

int main() {
    //input
    cin >> N >> M;
    for(int i = 0;i < N;i++) {
        string s; cin >> s;
        for(int j = 0;j < M;j++) {
            if(s[j] == 'L') map[i][j] = true;
        }
    }
    int answer = 0;
    //bfs
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            if(!map[i][j]) continue;
            vector<vector<int>> visited(N,vector<int>(M,-1));
            visited[i][j] = 0;
            queue<pair<int,int>> q;
            q.emplace(i,j);
            while(!q.empty()) {
                pair<int,int> p = q.front();
                q.pop();
                for(pair<int,int> move : moves) {
                    int i = p.first + move.first;
                    int j = p.second + move.second;
                    if(0 <= i && i < N && 0 <= j && j < M && map[i][j]) {
                        if(visited[i][j] == -1) {
                            visited[i][j] = visited[p.first][p.second] + 1;
                            answer = max(answer, visited[i][j]);
                            q.emplace(i,j);
                        }
                    }
                }
            }
        }
    }
    cout << answer;


    return 0;
}