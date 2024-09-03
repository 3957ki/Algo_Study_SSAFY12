#include<iostream>
#include<queue>
using namespace std;
typedef pair<int,int> pp;

bool visited[2000][2000];

int main() {
    int S; cin >> S;
    queue<pp> q;
    q.emplace(1,0); // 입력된 이모티콘, 클립보드 이모티콘
    visited[1][0] = true;
    int dist = 1;
    while(!q.empty()) {
        int qSize = q.size();
        for(int qs = 0;qs < qSize;qs++) {
            pp cur = q.front(); q.pop();
            //1. 클립보드에 저장하기
            if(!visited[cur.first][cur.first]) {
                visited[cur.first][cur.first] = true;
                q.emplace(cur.first, cur.first);
            }
            
            //2. 붙여넣기
            int a1 = cur.first+cur.second;
            int a2 = cur.second;
            if(a1 < 2000 && !visited[a1][a2]) {
                visited[a1][a2] = true;
                if(a1 == S) {
                    cout << dist;
                    exit(0);
                }
                q.emplace(a1, a2);
            }
            //3. 빼기
            if(cur.first > 0 && !visited[cur.first-1][cur.second]) {
                visited[cur.first-1][cur.second] = true;
                if(cur.first-1 == S) {
                    cout << dist;
                    exit(0);
                }
                q.emplace(cur.first-1,cur.second);
            }
            
        }

        dist++;
    }    
    return 0;
}