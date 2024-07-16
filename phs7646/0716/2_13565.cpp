#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int main() {
    int N,M; cin >> N >> M;
    pair<int,int> moves[4] = {{1,0},{0,1},{-1,0},{0,-1}};
    vector<vector<char>> board(N,vector<char>(M));
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            cin >> board[i][j];
        }
    }
    queue<pair<int,int>> q;
    for(int j = 0;j < M;j++) {
        if(board[0][j] == '0') {
            q.push({0,j});
            board[0][j] = '2'; //on
        }
    }
    while(!q.empty()) {
        pair<int,int> p = q.front();
        q.pop();
        for(pair<int,int> move : moves) {
            int i = p.first + move.first;
            int j = p.second + move.second;
            if(0 > i || i >= N || 0 > j || j >= M) continue;
            if(board[i][j] != '0') continue;
            board[i][j] = '2';
            q.push({i,j});
        }
    }
    /*
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }
    */

    for(int j = 0;j < M;j++) {
        if(board[N-1][j] == '2') {
            cout << "YES";
            return 0;
        }
    }
    cout << "NO";
    return 0;
}