#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int main() {
    int N; cin >> N;
    //X,Y,K means "X를 만드려면 Y가 K개 필요하다"
    //ahead가 없는게 기본 부품. 위상정렬하고 그 순서대로 재료 찾기
    vector<vector<pair<int,int>>> aheads(N+1); //aheads[i] : i를 만들기 위한 재료들
    vector<vector<int>> tails(N+1); //tails[i] : i로 만드는 다음 부품들
    vector<int> num_aheads(N+1);
    int M; cin >> M;
    for(int m = 0;m < M;m++) {
        int X,Y,K; cin >> X >> Y >> K;
        aheads[X].push_back({Y,K});
        tails[Y].push_back(X);
    }

    vector<int> basics;
    vector<vector<int>> howToMake(N+1);
    //basic조사
    for(int i = 1;i <= N;i++) {
        num_aheads[i] = aheads[i].size();
        if(num_aheads[i] == 0) {
            basics.push_back(i);
        }
    }
    int num_basic = basics.size();
    queue<int> top_queue;
    //basic의 howToMake등록
    for(int i = 0;i < num_basic;i++) {
        howToMake[basics[i]].resize(num_basic);
        howToMake[basics[i]][i] = 1;
        for(int next : tails[basics[i]]) {
            num_aheads[next]--;
            if(num_aheads[next] == 0) top_queue.push(next);
        }
    }
    //위상 정렬 시작
    while(!top_queue.empty()) {
        int target = top_queue.front();
        top_queue.pop();
        howToMake[target].resize(num_basic);
        for(pair<int,int> p : aheads[target]) {
            //p.first를 만드는 재료에 p.second를 곱하여 합산
            for(int i = 0;i < num_basic;i++) {
                howToMake[target][i] += howToMake[p.first][i] * p.second;
            }
        }
        //다 만들었다
        for(int tail : tails[target]) {
            num_aheads[tail]--;
            if(num_aheads[tail] == 0) top_queue.push(tail);
        }
    }
    
    for(int i = 0;i < num_basic;i++) {
        cout << basics[i] << " " << howToMake[N][i] << "\n";
    }


    return 0;
}