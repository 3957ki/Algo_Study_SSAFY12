#include<iostream>
#include<climits>
using namespace std;

int N;
int W[10][10];
bool visited[10];
int answer = INT_MAX;
int cur = 0;
int num_visit = 0;
void dfs(int prev) {
    if(num_visit == N) {
        if(W[prev][0] != 0) {
            answer = min(answer,cur+W[prev][0]);
        }
        return;
    }
    for(int i = 0;i < N;i++) {
        if(visited[i]) continue;
        if(W[prev][i] == 0) continue;
        //i를 방문
        visited[i] = true;
        cur += W[prev][i];
        num_visit++;
        dfs(i);
        num_visit--;
        cur -= W[prev][i];
        visited[i] = false;
    }
}

int main() {
    cin >> N;
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            cin >> W[i][j]; //0이면 갈 수 없다
        }
    }
    num_visit = 1;
    visited[0] = true; //0에서 시작
    dfs(0);
    cout << answer;
    return 0;
}