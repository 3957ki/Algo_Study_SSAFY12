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
    vector<int> in_degree(N, 0);
    for(int i = 0; i < N; i++) {
        for(int next : tails[i]) {
            in_degree[next]++;
        }
    }
    queue<int> q;
    for(int i = 0; i < N; i++) {
        if(in_degree[i] == 0) q.push(i);
    }
    int index = 0;
    while(!q.empty()) {
        int current = q.front();
        q.pop();
        topologic_order[index++] = current;
        for(int next : tails[current]) {
            if(--in_degree[next] == 0) {
                q.push(next);
            }
        }
    }
}

int main() {
    cin >> N >> M >> K;
    for(int i = 0; i < N; i++) cin >> t[i];
    for(int i = 0; i < M; i++) {
        int S, E; cin >> S >> E;
        S--; E--;
        aheads[E].push_back(S);
        tails[S].push_back(E);
    }
    //calculate topologic order first
    calculate_topologic();
    if(debug) {
        cout << "topologic order : ";
        for(int i = 0; i < N; i++) cout << topologic_order[i] << " ";
        cout << endl;
    }
    //calculate original node time
    original[0] = t[0];
    for(int i = 1; i < N; i++) {
        int target = topologic_order[i];
        for(int ahead : aheads[target]) {
            original[target] = max(original[target], original[ahead]);
        }
        original[target] += t[target];
    }
    if(debug) {
        cout << "original node time : ";
        for(int i = 0; i < N; i++) cout << original[i] << " ";
        cout << endl;
    }
    int lastNode = topologic_order[N-1];
    for(int k = 0; k < K; k++) {
        //각 노드가 기여하는 값을 계산하고, 기여가 가장 큰 노드를 0초로 만들자
        vector<int> nodeTime_backup(N);
        int max_target = -1;
        int max_decrease = 0;
        for(int i = 1; i < N-1; i++) { //양 끝은 제외
            vector<int> cur(original, original + N);
            int target = topologic_order[i]; //target을 0초로 바꾸면 어떻게 될까?
            cur[target] -= t[target]; //targetNode가 t[target]만큼 줄어듦
            //영향을 받는건 target 이후에 오는 노드들.. 다시 계산
            for(int j = i+1; j < N; j++) {
                int update = topologic_order[j];
                cur[update] = 0;
                for(int ahead : aheads[update]) cur[update] = max(cur[update], cur[ahead]);
                cur[update] += t[update];
            }
            //계산 완료
            int decrease = original[lastNode] - cur[lastNode];
            if(decrease > max_decrease) {
                //최댓값 업데이트
                max_decrease = decrease;
                max_target = target;
                for(int i = 0; i < N; i++) nodeTime_backup[i] = cur[i];
            }
        }
        //최대 감소를 일으키는 노드를 0초로 만든다
        if(max_target == -1) break; //더이상 감소를 일으키는 애가 없음
        t[max_target] = 0;
        for(int i = 0; i < N; i++) original[i] = nodeTime_backup[i];
    }
    cout << original[lastNode];

    return 0;
}
