#include<iostream>
#include<vector>

using namespace std;
int val[6][3];
int cur[6][3];
int result[6][6];
pair<int,int> next(pair<int,int> p) {
    int i = p.first;
    int j = p.second;
    int n = i*6 + j + 1;
    int newi = n/6;
    int newj = n%6;
    if(newi == newj) return next({newi,newj});
    return {newi,newj};
} 
bool dfs(pair<int,int> p) {
    int i = p.first;
    int j = p.second;
    //cout << "dfs call " << i << " " << j << endl;
    //i와 j의 경기 결과 정하기
    if(i >= 6) return true; //끝까지 왔다
    if(result[i][j] != 0) return dfs(next(p)); //이미 정해진 결과

    //i가 이겼다!
    if(cur[i][0] < val[i][0] && cur[j][2] < val[j][2]) {
        result[i][j] = 1;
        result[j][i] = 3;
        cur[i][0]++;
        cur[j][2]++;
        if(dfs(next(p))) return true;
        result[i][j] = 0;
        result[j][i] = 0;
        cur[i][0]--;
        cur[j][2]--;
    }
    //j가 이겼다!
    if(cur[i][2] < val[i][2] && cur[j][0] < val[j][0]) {
        result[i][j] = 3;
        result[j][i] = 1;
        cur[i][2]++;
        cur[j][0]++;
        if(dfs(next(p))) return true;
        result[i][j] = 0;
        result[j][i] = 0;
        cur[i][2]--;
        cur[j][0]--;
    }
    //비겼다!
    if(cur[i][1] < val[i][1] && cur[j][1] < val[j][1]) {
        result[i][j] = 2;
        result[j][i] = 2;
        cur[i][1]++;
        cur[j][1]++;
        if(dfs(next(p))) return true;
        result[i][j] = 0;
        result[j][i] = 0;
        cur[i][1]--;
        cur[j][1]--;
    }
    return false;
}
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    for(int t = 1;t <= 4;t++) {
        bool answer = true;
        //input
        for(int i = 0;i < 6;i++) {
            for(int j = 0;j < 3;j++) {
                cin >> val[i][j];
                cur[i][j] = 0;
            }
        }
        for(int i = 0;i < 6;i++) {
            for(int j = 0;j < 6;j++) {
                result[i][j] = 0; //0:unknown 1: win 2 : draw 3:lose
            }
        }
        //예외처리
        bool cont = false;
        //case1 : 각팀 승무패합 5이하
        for(int i = 0;i < 6;i++) {
            if(val[i][0] + val[i][1] + val[i][2] != 5) {
                cont = true;
                cout << 0 << " ";
                break;
            }
        }
        if(cont) continue;
        if(dfs({0,1})) cout << 1 << " ";
        else cout << 0 << " ";
    }
    return 0;
}