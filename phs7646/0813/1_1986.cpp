#include<iostream>
#include<vector>
using namespace std;

int map[1000][1000];
bool die[1000][1000];

pair<int,int> knight_move[] = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},
    {2,-1},{1,-2}};
pair<int,int> queen_move[] = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
int main() {
    int N,M; cin >> N >> M;

    int Q; cin >> Q;
    vector<pair<int,int>> queens(Q);
    for(int q = 0;q < Q;q++) {
        int a,b; cin >> a >> b;
        a--; b--;
        queens[q] = {a,b};
        map[a][b] = 1;//something
        die[a][b] = true;
    }

    int K; cin >> K;
    vector<pair<int,int>> knights(K);
    for(int q = 0;q < K;q++) {
        int a,b; cin >> a >> b;
        a--; b--;
        knights[q] = {a,b};
        map[a][b] = 1;//something
        die[a][b] = true;
    }

    int P; cin >> P;
    for(int q = 0;q < P;q++) {
        int a,b; cin >> a >> b;
        a--; b--;
        map[a][b] = 1;//something
        die[a][b] = true;
    }

    //apply knights
    for(pair<int,int> p : knights) {
        for(pair<int,int> move : knight_move) {
            int i = p.first + move.first;
            int j = p.second + move.second;
            if(0 <= i && i < N && 0 <= j && j < M) die[i][j] = true;
        }
    }

    //apply queens
    for(pair<int,int> p : queens) {
        //각 방향으로 장애물이 있을 때 까지 진행
        for(pair<int,int> move : queen_move) {
            int i = p.first + move.first;
            int j = p.second + move.second;
            while(0 <= i && i < N && 0<= j && j < M) {
                if(map[i][j] == 1) break;
                die[i][j] = true;
                i += move.first;
                j += move.second;
            }
        }
    }

    //count
    int answer = 0;
    for(int i = 0;i < N;i++) for(int j = 0;j < M;j++) {
        if(!die[i][j]) answer++;
    }

    cout << answer;

    return 0;
}