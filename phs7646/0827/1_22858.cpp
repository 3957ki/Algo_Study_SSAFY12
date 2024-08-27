#include<iostream>

using namespace std;

#define MAX 10000

int arr[2][MAX+1];
int D[MAX+1];
int main() {
    int N,K; cin >> N >> K;
    for(int i = 1;i <= N;i++) cin >> arr[0][i];
    for(int i = 1;i <= N;i++) cin >> D[i];

    bool flag = true;
    for(int k = 0;k < K;k++) {
        //각 i에 대해 i를 Di로 옮김
        if(flag) {
            //0 -> 1
            for(int i = 1;i <= N;i++) arr[1][D[i]] = arr[0][i];
        }
        else {
            //1 -> 0
            for(int i = 1;i <= N;i++) arr[0][D[i]] = arr[1][i];
        }
        flag = !flag;

    }
    if(flag) for(int i = 1;i <= N;i++) cout << arr[0][i] << " ";
    else for(int i = 1;i <= N;i++) cout << arr[1][i] << " ";
    
    return 0;
}