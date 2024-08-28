#include<iostream>
#include<string>
#include<queue>

using namespace std;
typedef pair<int,int> pp;
int H,W;
int map[1000][1000];
bool willCollapse[1000][1000];

bool isValid(int i,int j) {
    if(0 > i || 0 > j || i >= H || j >= W) return false;
    return true;
}
int countNear(int i,int j) {
    int ret = 0;
    for(int a = i-1; a <= i+1;a++) {
        for(int b = j-1; b <= j+1;b++) {
            if(a==i && b==j) continue;
            if(!isValid(a,b)) continue;
            if(map[a][b] == 0)  ret++;
        }
    }
    return ret;
}

int main() {
    cin >> H >> W;
    for(int i = 0;i < H;i++) {
        string s; cin >> s;
        for(int j = 0;j < W;j++) {
            if(s[j] == '.') map[i][j] = 0;
            else map[i][j] = s[j]-'0';
        }
    }
    //초기 큐 빌드
    queue<pp> q;
    for(int i = 0;i < H;i++) {
        for(int j = 0;j < W;j++) {
            if(map[i][j] == 0) continue;
            if(countNear(i,j) >= map[i][j]) {
                q.emplace(i,j);
            }
        }
    }
    int day = 0;
    while(!q.empty()) {
        //qSize만큼 진행 = 오늘 무너지는 모래성
        int qSize = q.size();
        for(int _ = 0; _ < qSize; _++) {
            pp cur = q.front(); q.pop();
            int y = cur.first;
            int x = cur.second;
            //부수기
            map[y][x] = 0;

            //cur주변 8개 모래성이 다음날 부서질지 확인하고 큐에 넣기
            for(int i = y-1;i <= y+1;i++) {
                for(int j = x-1;j <= x+1;j++) {
                    if(i==y && j == x) continue;
                    if(!isValid(i,j)) continue;
                    if(map[i][j] == 0) continue;
                    if(willCollapse[i][j]) continue;
                    if(countNear(i,j) >= map[i][j]) {
                        q.emplace(i,j);
                        willCollapse[i][j] = true;
                    }
                }
            }
        }
        day++;
    }
    cout << day;
    return 0;
}