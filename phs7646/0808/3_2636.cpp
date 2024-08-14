#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int board[100][100]; //0 빈땅 1 치즈 n : n-1시간째에 녹아없어진 치즈
int N,M;
pair<int,int> moves[] = {{0,1},{1,0},{-1,0},{0,-1}};
int main() {
    cin.tie(nullptr);
    cin >> N >> M;
    int num_left = 0;
    for(int i = 0;i < N;i++) for(int j = 0;j < M;j++) {
        cin >> board[i][j];
        if(board[i][j]) num_left++;
    }
    int day = 0;
    
    while(num_left > 0) {
        //day인날 진행
        //1을 만나면 day+2로 마크하고 멈추고,
        //day+2를 만나면 멈춤
        queue<pair<int,int>> q;
        vector<vector<bool>> visited(N,vector<bool>(M));
        q.emplace(0,0);
        visited[0][0] = true;
        while(!q.empty()) {
            pair<int,int> p = q.front(); q.pop();
            for(int d = 0;d < 4;d++) {
                int i = p.first + moves[d].first;
                int j = p.second + moves[d].second;
                if(0 > i || i >= N || 0 > j || j >= M) continue;
                if(visited[i][j]) continue;
                visited[i][j] = true;
                if(board[i][j] == 1) {
                    board[i][j] = day+2;
                    num_left--;
                } else if(board[i][j] != day+2) {
                    q.emplace(i,j);
                }
            }
        }
        day++;
    }
    // for(int i = 0;i < N;i++) {
    //     for(int j = 0;j < M;j++) {
    //         cout << board[i][j] << " ";
    //     }
    //     cout << endl;
    // }
    int num = 0;
    for(int i = 0;i < N;i++) for(int j = 0;j < M;j++) {
        if(board[i][j] == day+1) num++;
    }
    cout << day << "\n" << num;
    return 0;
}