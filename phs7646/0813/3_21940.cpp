#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N,M;
int dist[201][201]; //0 : can't reach
int friends[201];
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    //input
    cin >> N >> M;
    for(int m = 0;m < M;m++) {
        int a,b,c; cin >> a >> b >> c;
        dist[a][b] = c;
    }
    int K; cin >> K;
    for(int k = 0;k < K;k++) cin >> friends[k];

    //플로이드 워셜
    for(int k = 1;k <= N;k++) {
        for(int i = 1;i <= N;i++) {
            if(dist[i][k] == 0) continue;
            for(int j = 1;j <= N;j++) {
                if(dist[k][j] == 0) continue;
                //i->j update by i->k + k->j
                int new_cost = dist[i][k] + dist[k][j];
                if(dist[i][j] == 0 || dist[i][j] > new_cost) {
                    dist[i][j] = new_cost;
                }
            }
        }
    }

    int answer_cost = 2100000007;
    vector<int> answers;
    //각 도시에 대해 왕복거리의 최대 구하기
    for(int c = 1;c <= N;c++) {
        int cur_cost = 0;
        bool flag = true; //가능한가
        for(int k = 0;k < K;k++) {
            //friend k 의 왕복거리
            int city = friends[k];
            if(city == c)  continue; //ok
            if(dist[city][c] == 0 || dist[c][city] == 0) {
                flag = false;
                break;
            }
            cur_cost = max(cur_cost,dist[city][c] + dist[c][city]);
        }
        if(!flag) continue; //불가능한 경우
        if(cur_cost < answer_cost) {
            answers.clear();
            answers.emplace_back(c);
            answer_cost = cur_cost;
        } else if(cur_cost == answer_cost) answers.emplace_back(c);
    }
    for(int c : answers) cout << c << " ";
    return 0;
}