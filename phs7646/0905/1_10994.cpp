#include <iostream>
#include<vector>
using namespace std;
int N; 
int main() {
    ios_base::sync_with_stdio(false);
    cin >> N;
    //1 + 4*(N-1)
    int len = 1 + 4*(N-1);
    vector<vector<char>> ret(len,vector<char>(len,' '));

    for(int i = 0;i < len;i++) {
        for(int j = 0;j < len;j++) {
            int pad1 = min(i,j);
            int pad2 = min(len-i-1,len-j-1);
            int pad = min(pad1,pad2);
            if(!(pad&1)) ret[i][j] = '*';
        }
    }

    for(int i = 0;i < len;i++) {
        for(int j = 0;j < len;j++) {
            cout << ret[i][j];
        }
        cout << "\n";
    }
    return 0;
}