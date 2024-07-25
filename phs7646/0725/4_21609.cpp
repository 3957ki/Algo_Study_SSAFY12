#include<vector>
#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;
int N,M;
vector<vector<int>> board;

bool debug = false;

void boardPrint() {
    cout << "Printing board-----\n";
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }
}

void rotate() {
    vector<vector<int>> ret(N,vector<int>(N));
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            ret[N-j-1][i] = board[i][j];
        }
    }
    board = ret;
}

void gravity() {
    for(int j = 0;j < N;j++) {
        //j열에 대해
        vector<int> h;
        //맨윗행부터 아래로가면서 수집
        int index = 0;
        while(index < N) {
            if(board[index][j] == -1) {
                //여태까지 쌓인 데이터를 역순으로 배치
                for(int k = 0;k < h.size();k++) {
                    board[index-1-k][j] = h[h.size()-1-k];
                }
                h.clear();
            } else if(board[index][j] != -2) {
                h.push_back(board[index][j]);
                board[index][j] = -2;
            }
            index++;
        }
        //여태까지 쌓인 데이터를 역순으로 배치
        for(int k = 0;k < h.size();k++) {
            board[index-1-k][j] = h[h.size()-1-k];
        }
    }
}

int main() {
    cin >> N >> M;
    long long answer = 0;
    board.resize(N,vector<int>(N));
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            cin >> board[i][j];
        }
    }
    pair<int,int> moves[] = {{0,1},{1,0},{-1,0},{0,-1}};
    while(true) {
        //play bfs
        //일반 블록에서 시작, 블럭갯수 최대(무지개 갯수 최대) 만들기
        int maxBlocks = 0;
        int maxRainbow = 0;
        vector<vector<bool>> maxVisited;
        vector<vector<bool>> globalVisited(N,vector<bool>(N));
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < N;j++) {
                if(board[i][j] <= 0) continue;
                if(globalVisited[i][j]) continue;
                //i,j에서 시작하는 블럭 그룹 구해보기
                int numBlocks = 0;
                int numRainbow = 0;
                int targetColor = board[i][j];
                vector<vector<bool>> visited(N,vector<bool>(N));
                queue<pair<int,int>> q;
                q.push({i,j});
                numBlocks++;
                visited[i][j] = true;
                while(!q.empty()) {
                    pair<int,int> p = q.front();
                    q.pop();
                    for(auto move : moves) {
                        int nexti = p.first+move.first;
                        int nextj = p.second+move.second;
                        if(0 <= nexti && nexti < N && 0 <= nextj && nextj < N) {
                            if(visited[nexti][nextj]) continue;
                            if(board[nexti][nextj] == targetColor) {
                                q.push({nexti,nextj});
                                numBlocks++;
                                visited[nexti][nextj] = true;
                                globalVisited[nexti][nextj] = true;
                            } else if(board[nexti][nextj] == 0) {
                                q.push({nexti,nextj});
                                numRainbow++;
                                numBlocks++;
                                visited[nexti][nextj] = true;
                            }
                        }
                    }
                }
                //bfs 완료!
                if(numBlocks > maxBlocks || (numBlocks == maxBlocks && numRainbow >= maxRainbow)) {
                    //업데이트
                    maxBlocks = numBlocks;
                    maxRainbow = numRainbow;
                    maxVisited = visited;
                }
            }
        }
        //최고의 그룹을 찾았다!
        if(maxBlocks <= 1) {
            cout << answer;
            return 0;
        }
        answer += maxBlocks * maxBlocks;
        //해당 그룹 삭제하기
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < N;j++) {
                if(maxVisited[i][j]) {
                    board[i][j] = -2;
                }
            }
        }
        if(debug) {
            cout << "After delete..\n";
            boardPrint();
        }
        //중력 작용
        gravity();
        if(debug) {
            cout << "After gravity..\n";
            boardPrint();
        }
        //회전
        rotate();
        if(debug) {
            cout << "After rotate..\n";
            boardPrint();
        }
        //중력 작용
        gravity();
        if(debug) {
            cout << "After gravity..\n";
            boardPrint();
        }
    }
    return 0;
}