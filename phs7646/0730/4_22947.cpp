#include<iostream>
#include<vector>
#include<queue>
#define debug 0
using namespace std;

int N,M,K;
int t[100];
int topologic_order[100];
vector<int> aheads[100];
vector<int> tails[100];
int original[100];

void calculate_topologic() {
    //calculate topologic order
    vector<bool> visited(N);
    visited[0] = true;
    topologic_order[0] = 0;
    for(int index = 1;index < N;index++) {
        for(int i = 1;i < N;i++) {
            if(visited[i]) continue;
            //ahead가 모두 visit되었는가?
            bool flag = true;
            for(int ahead : aheads[i]) {
                if(!visited[ahead]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                topologic_order[index] = i;
                visited[i] = true;
                break;
            }
        }
    }
}

int main() {
    cin >> N >> M >> K;
    for(int i = 0;i < N;i++) cin >> t[i];
    for(int i = 0;i < M;i++) {
        int S,E; cin >> S >> E;
        S--; E--;
        aheads[E].push_back(S);
        tails[S].push_back(E);
    }
    //calculate topologic order first
    calculate_topologic();
    if(debug) {
        cout << "topologic order : ";
        for(int i = 0;i < N;i++) cout << topologic_order[i] << " ";
        cout << endl;
    }
    //calculate original node time
    original[0] = t[0];
    for(int i = 1;i < N;i++) {
        int target = topologic_order[i];
        //target의 node time을 구하기
        for(int ahead : aheads[target]) {
            original[target] = max(original[target],original[ahead]);
        }
        original[target] += t[target];
    }
    if(debug) {
        cout << "original node time : ";
        for(int i = 0;i < N;i++) cout << original[i] << " ";
        cout << endl;
    }
    int lastNode = topologic_order[N-1];

    if(K == 0) {
        cout << original[lastNode];
        return 0;
    }
    //완전 탐색으로 K개 고르기
    vector<vector<int>> selected;
    for(int i = 1;i < N-1;i++) {
        if(K==1) {
            selected.push_back({i});
            continue;
        }
        for(int j = i+1;j < N-1;j++) {
            if(K==2) {
                selected.push_back({i,j});
                continue;
            }
            for(int k = j+1;k < N-1;k++) {
                selected.push_back({i,j,k});
            }
        }
    }
    int answer = original[lastNode];
    for(vector<int> select : selected) {
        //해당 case에서 계산
        vector<int> cur(N);
        for(int i = 0;i < N;i++) cur[i] = original[i];
        for(int s : select) {
            //s를 제외시키기
            int target = topologic_order[s];
            cur[target] -= t[target];
            for(int j = s+1;j < N;j++) {
                int update = topologic_order[j];
                cur[update] = 0;
                for(int ahead : aheads[update]) cur[update] = max(cur[update],cur[ahead]);
                cur[update] += t[update];
            }
        }
        if(answer > cur[lastNode]) answer = cur[lastNode];
    }
    cout << answer;
    return 0;
}