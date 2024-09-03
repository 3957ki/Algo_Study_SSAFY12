#include<iostream>
#include<vector>
using namespace std;

int main() {
    int N,M; cin >> N >> M;
    vector<bool> broken(N-1);
    for(int m = 0;m < M;m++) {
        int x,y; cin >> x >> y;
        for(int i = x; i <= y-1;i++) {
            broken[i] = true;
        }
    }
    
    //방의 갯수는 벽의 갯수
    int answer = 0;
    for(int i = 0;i <= N-1;i++) if(!broken[i]) answer++;
    cout << answer;
    return 0;
}