#include<iostream>
#include<queue>
#include<vector>
#define debug 1
using namespace std;
typedef pair<int,int> pp;
int N;
int map[20][20];
pp moves[] = {{0,1},{1,0},{-1,0},{0,-1}};
int main() {
    //input
    int M,F; cin >> N >> M >> F;
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            cin >> map[i][j];
        }
    }
    int cury,curx; cin >> cury >> curx; cury--; curx--;
    for(int m = 0;m < M;m++) {
        int a,b,c,d;
        cin >> a >> b >> c >> d;
        a--;b--;c--;d--;
        map[a][b] = -1 * (c*N+d) - 1 ; //0,0이 목표라면...? 0이됨... -1 pad
    }

    vector<vector<bool>> visited;
    queue<pp> q;
    for(int m = 0;m < M;m++) {
        if(debug) {
            cout << m+1 << "번째 승객 찾으러가기 " << endl;
            for(int i = 0;i < N;i++) {
                for(int j = 0;j < N;j++) {
                    cout << map[i][j] << " ";
                }
                cout << endl;
            }
        }
        //cur에서 가장 가까운 승객을 찾는다 (bfs)
        int targety = -1, targetx = -1;
        int dist = 0;
        if(map[cury][curx] < 0) {
            targety = cury;
            targetx = curx;
        } else {
            q = queue<pp>();
            visited = vector<vector<bool>>(N,vector<bool>(N));
            q.emplace(cury,curx);
            visited[cury][curx] = true;
            while(!q.empty()) {
                int qSize = q.size();
                for(int k = 0;k < qSize;k++) {
                    pp p = q.front(); q.pop();
                    for(int d = 0;d < 4;d++) {
                        int ni = p.first + moves[d].first;
                        int nj = p.second + moves[d].second;
                        if(0<=ni && ni < N && 0 <= nj && nj < N && map[ni][nj] != 1 && !visited[ni][nj]) {
                            visited[ni][nj] = true;
                            if(map[ni][nj] < 0) {
                                //found customer
                                if(targety == -1) {
                                    targety = ni;
                                    targetx = nj;
                                } else if(targety > ni || (targety==ni && targetx > nj)) {
                                    targety = ni;
                                    targetx = nj;
                                }
                            } else {
                                //blank
                                if(targety == -1) q.emplace(ni,nj);
                            }
                        }
                    }
                }
                dist++;
                if(targety != -1) break;
            }
        }
        if(targety == -1 || dist > F) { //태울 수 있는 승객이 없다,,
            if(debug) cout << "태울 수 있는 승객 없음.." << endl;
            cout << -1; return 0;
        }
        if(debug) cout << "승객 위치 : " << targety << " " << targetx << " " << dist << endl;
        
        //승객에 방문한다
        F -= dist;
        cury = targety;
        curx = targetx;
        int goal = -1 * (map[cury][curx]+1);
        int goaly = goal / N;
        int goalx = goal % N;
        map[cury][curx] = 0; //set blank
        if(debug) cout << "승객 탑승, 남은 연료 : " << F << endl;
        if(debug) cout << "목표 : " << goaly << " " << goalx << endl;
        //승객에서 목적지 까지 거리 계산 (bfs)
        dist = 0;
        bool found = false;
        if(cury == goaly && curx == goalx) {
            found = true;
        } else {
            //cur -> goal
            q = queue<pp>();
            visited = vector<vector<bool>>(N,vector<bool>(N));
            visited[cury][curx] = true;
            
            q.emplace(cury,curx);
            while(!q.empty()) {
                int qSize = q.size();
                for(int k = 0;k < qSize;k++) {
                    pp p = q.front(); q.pop();
                    for(int d = 0;d < 4;d++) {
                        int ni = p.first + moves[d].first;
                        int nj = p.second + moves[d].second;
                        if(0<=ni && ni < N && 0 <= nj && nj < N && map[ni][nj] != 1 && !visited[ni][nj]) {
                            visited[ni][nj] = true;
                            if(ni == goaly && nj == goalx) {
                                found = true; break;
                            }
                            q.emplace(ni,nj);
                        }
                    }
                    if(found) break;
                }
                dist++;
                if(found)break;
            }
        }
        if(!found || dist > F) {
            if(debug)cout << "목적지에 갈 수 없음.." << endl;
            cout << -1;
            return 0;
        }
        if(debug) cout << "목적지 까지 거리 : " << dist << endl;

        //목적지에 간다(이동거리 * 2 연료 충전)
        F += dist;
        cury = goaly;
        curx = goalx;
        if(debug) cout << "승객 한명 완료. 위치 : " << cury << " " << curx << " 남은 연료 :" << F << endl;
    }
    cout << F << endl;
    
    return 0;
}