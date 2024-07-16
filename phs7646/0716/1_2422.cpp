#include<iostream>
#include<vector>

using namespace std;
bool rel[201][201];
int main() {
    int N,M; cin >> N >> M;
    for(int i = 0;i < M;i++) {
        int a,b; cin >> a >> b;
        rel[a][b] = true;
        rel[b][a] = true;
    }
    int answer = 0;
    for(int i = 1;i <= N;i++) {
        for(int j = i+1;j <= N;j++) {
            if(rel[i][j]) continue;
            for(int k = j+1;k <= N;k++) {
                if(rel[i][k] || rel[j][k]) continue;
                answer++;
            }
        }
    }
    cout << answer;
    return 0;
}