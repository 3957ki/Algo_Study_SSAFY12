#include <iostream>
#include <string>
#include <vector>

using namespace std;

int R,C;
vector<string> board;
bool visited[250][250];

pair<int,int> moves[] = {{0,1},{1,0},{-1,0},{0,-1}};
int wc;
int sc;

void dfs(int i,int j) {
    for(int d = 0;d < 4;d++) {
        int i2 = i + moves[d].first;
        int j2 = j + moves[d].second;
        if(0 <= i2 && i2 < R && 0 <= j2 && j2 < C && !visited[i2][j2]) {
            char c = board[i2][j2];
            if(c == '#') continue;;
            if(c == 'v') wc++;
            else if(c == 'k') sc++;
            visited[i2][j2] = true;
            dfs(i2,j2);
        }
    }
}

int main() {
    cin >> R >> C;
    board.resize(R);
    int answer_w = 0;
    int answer_s = 0;
    for(int i = 0;i < R;i++) cin >> board[i];
    for(int i = 0;i < R;i++) {
        for(int j = 0;j < C;j++) {
            if(visited[i][j]) continue;
            if(board[i][j] == '#') continue;
            
            wc = 0;
            sc = 0;
            if(board[i][j] == 'v') wc++;
            if(board[i][j] == 'k') sc++;
            visited[i][j] = true;
            dfs(i,j);
            if(wc >= sc) answer_w += wc;
            else answer_s += sc;
        }
    }
    cout << answer_s << " " << answer_w;
    return 0;
}