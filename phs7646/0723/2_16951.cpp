// 수정해야 하는 탑의 갯수는?

#include <iostream>

using namespace std;
int A[1000];
int main() {
    int N,K;
    cin >> N >> K;
    for(int i = 0;i < N;i++) cin >> A[i];
    int answer = N;
    for(int i = 0;i < N;i++) {
        //i번쨰 항 기준!
        int count = 0;
        //가능한가?
        if(A[i] - K * i <  1) continue;
        //왼쪽놈들 수정
        for(int j = i-1;j >= 0;j--) {
            if(A[j] != A[i] - K * (i-j)) count++;
        }
        //오른쪽놈들 수정
        for(int j = i+1;j < N;j++) {
            if(A[j] != A[i] + K * (j-i)) count++;
        }
        answer = min(answer,count);
    }
    cout << answer;
    return 0;
}