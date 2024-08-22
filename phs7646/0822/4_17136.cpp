#include<iostream>
#define debug 0
using namespace std;

int map[10][10];
bool visited[10][10]; //붙였는지?
int have[] = {5,5,5,5,5};
int answer = 26;

void dfs() {
    //종이가 안붙은 공간 탐색
    int y = -1,x = -1;
    for(int i = 0;i < 10;i++) {
        for(int j = 0;j < 10;j++) {
            if(map[i][j] == 1 && !visited[i][j]) {
                y = i;
                x = j;
                break;
            }
        }
        if(y >= 0) break;
    }
    if(debug) {
        cout << "dfs target : " << y << " " << x << endl;
    }
    if(y == -1 && x == -1) {
        //success!!
        if(debug) {
            cout << "Success! remain : ";
            for(int c : have) cout << c << " ";
            cout << endl;
        }
        int s = 0;
        for(int c : have) s += c;
        answer = min(answer,25-s);
        return;
    }
    //붙일 수 있는 가장 큰 종이
    int maxSize = 1;
    while(maxSize < 5) {
        //i+m 행 과 j+m 열이 다 1이면 확장
        if(y+maxSize >= 10 || x+maxSize >= 10) break;
        bool flag = true;
        for(int a = 0; a <= maxSize;a++) {
            //i+m , j+a 와 i+a , j+m
            if(map[y+maxSize][x+a] == 0 || visited[y+maxSize][x+a]) flag = false;
            else if(map[y+a][x+maxSize] == 0 || visited[y+a][x+maxSize]) flag = false;
            if(!flag) break;
        }
        if(!flag) break;
        maxSize++;
    }

    //종이를 붙이자
    for(int m = 0;m < maxSize;m++) {
        
        //m+1크기의 종이를 붙이자!
        for(int a = 0; a <= m;a++) {
            visited[y+m][x+a] = true;
            visited[y+a][x+m] = true;
        }
        if(debug) cout << "attach " << y << " " << x << " " << m+1 << endl;
        if(have[m] == 0) continue;
        have[m]--;
        dfs(); //진행!
        have[m]++;
        if(debug) cout << "detach " << y << " " << x << " " << m+1 << endl;
    }

    //붙였던거 떼자
    for(int i = 0;i < maxSize;i++) {
        for(int j = 0;j < maxSize;j++) {
            visited[y+i][x+j] = false;
        }
    }
}


int main() {
    //input
    for(int i = 0;i < 10;i++) {
        for(int j = 0;j < 10;j++) {
            cin >> map[i][j];
        }
    }
    dfs();
    if(answer == 26) cout << -1;
    else cout << answer;

    return 0;
}