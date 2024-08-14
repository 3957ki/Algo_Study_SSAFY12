#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

bool input[5][5][5];
bool cube[5][5][5];
bool backup[5][5];
int dist[5][5][5];
int answer = -1;
int di[] = {-1, 1, 0, 0, 0, 0};
int dj[] = {0, 0, -1, 1, 0, 0};
int dk[] = {0, 0, 0, 0, -1, 1};
pair<int, int> startpoints[] = {{0, 0}, {0, 4}, {4, 0}, {4, 4}};
pair<int, int> endpoints[] = {{4, 4}, {4, 0}, {0, 4}, {0, 0}};

void rotate(int level) {
    for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
            backup[j][k] = cube[level][j][k];
        }
    }
    for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
            cube[level][k][4 - j] = backup[j][k];
        }
    }
}

void bfs() {
    for (int t = 0; t < 4; t++) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                for (int k = 0; k < 5; k++)
                    dist[i][j][k] = -1;

        pair<int, int> start = startpoints[t];
        if (!cube[0][start.first][start.second]) continue;

        dist[0][start.first][start.second] = 0;
        queue<pair<int, pair<int, int>>> q;
        q.push({0, start});
        
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int i = p.first;
            int j = p.second.first;
            int k = p.second.second;

            for (int m = 0; m < 6; m++) {
                int _i = i + di[m];
                int _j = j + dj[m];
                int _k = k + dk[m];

                if (_i < 0 || _i >= 5 || _j < 0 || _j >= 5 || _k < 0 || _k >= 5) continue;
                if (dist[_i][_j][_k] >= 0 || !cube[_i][_j][_k]) continue;

                dist[_i][_j][_k] = dist[i][j][k] + 1;
                q.push({_i, {_j, _k}});
            }
        }

        int cur_answer = dist[4][endpoints[t].first][endpoints[t].second];
        if (cur_answer != -1) {
            if (answer == -1 || answer > cur_answer) {
                answer = cur_answer;
            }
        }
    }
}

void dfs(int level) {
    if (level == 5) {
        bfs();
        return;
    }

    dfs(level + 1);
    for (int r = 0; r < 3; r++) {
        rotate(level);
        dfs(level + 1);
    }
}

int main() {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                cin >> input[i][j][k];
            }
        }
    }
    vector<int> v = {0,1,2,3,4};
    do {
        //v의 순서대로 cube 쌓기
        for(int level = 0;level < 5;level++) {
            for(int j = 0;j < 5;j++) {
                for(int k = 0;k < 5;k++) {
                    cube[level][j][k] = input[v[level]][j][k];
                }
            }
        }
        //진행
        dfs(1);
    } while(next_permutation(v.begin(),v.end()));

    cout << answer;
    return 0;
}
