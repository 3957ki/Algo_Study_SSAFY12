#include<iostream>
#include<vector>

using namespace std;
int N,M;
bool A[50][50];
bool B[50][50];
bool isSame() {
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < M;j++) {
            if(A[i][j] != B[i][j]) {
                return false;
            }
        }
    }
    return true;
}
int main() {
    cin >> N >> M;
    for(int i = 0;i < N;i++) for(int j = 0;j < M;j++) {
        char c; cin >> c;
        A[i][j] = c=='1';
    }
    for(int i = 0;i < N;i++) for(int j = 0;j < M;j++) {
        char c; cin >> c;
        B[i][j] = c=='1';
    }
    
    //예외
    if(N < 3 || M < 3) {
        if(isSame()) cout << 0;
        else cout << -1;
        return 0;
    }

    //같은 칸을 두번 뒤집는건 의미가 없다..!
    //왼쪽위칸이 오른쪽 아래로 3칸씩을 뒤집는다..!
    int count = 0;
    vector<vector<bool>> answer(N-2,vector<bool>(M-2,false));
    for(int i = 0;i < N-2;i++) {
        for(int j = 0;j < M-2;j++) {
            //cout << "checking " << i << " " << j << endl;
            if(A[i][j] != B[i][j]) {
                //must flip
                count++;
                answer[i][j] = true;
                for(int a = i; a < i+3;a++) {
                    for(int b = j; b < j+3;b++) {
                        A[a][b] = !A[a][b];
                    }
                }
            }
        }
    }
    if(isSame()) {
        cout << count;
    } else {
        cout << -1;
    }
    

    return 0;
}