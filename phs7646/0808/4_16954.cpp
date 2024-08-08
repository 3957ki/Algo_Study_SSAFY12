#include<iostream>
#include<string>
#include<vector>
using namespace std;

string board[8];
int main() {
    for(int i = 0;i < 8;i++) cin >> board[i];
    vector<vector<bool>> possible(8,vector<bool>(8));
    possible[7][0] = true;
    while(true) {
        vector<vector<bool>> new_possible(8,vector<bool>(8));
        //캐릭터가 움직인다
        for(int i = 0;i < 8;i++) {
            for(int j = 0;j < 8;j++) {
                if(board[i][j] == '#') continue;
                //인접한 칸 중 possible 칸이 있다면 new_possible
                for(int a = i-1;a <= i+1;a++) {
                    for(int b = j-1;b <= j+1;b++) {
                        if(a < 0 || a >= 8 || b < 0 || b >= 8) continue;
                        if(possible[a][b]) new_possible[i][j] = true;
                    }
                }
            }
        }
        if(new_possible[0][7]) {
            cout << 1;
            return 0;
        }

        //벽이 움직이고, possible에 변화를 준다
        for(int i = 7;i > 0;i--) {
            for(int j = 0;j < 8;j++) {
                board[i][j] = board[i-1][j];
                if(board[i][j] == '#') new_possible[i][j] = false;
            }
        }
        for(int j = 0;j < 8;j++) board[0][j] = '.';

        

        //모든 possible이 0이라면 실패다
        bool endflag = true;
        for(int i = 0;i < 8;i++) {
            for(int j = 0;j < 8;j++) {
                if(new_possible[i][j]) {
                    endflag= false;
                    break;
                }
            }
            if(!endflag) break;
        }
        if(endflag) break;
        possible = new_possible;

        ////현재 possible
        // for(int i = 0;i < 8;i++) {
        //     for(int j = 0;j < 8;j++) {
        //         cout << possible[i][j] << " ";
        //     }
        //     cout << endl;
        // }
        // cout << endl;
    }
    cout << 0;
    return 0;
}