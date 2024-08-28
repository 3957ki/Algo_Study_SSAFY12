#include<iostream>

using namespace std;


int main() {
    int N,K; cin >> N >> K;
    int sumK = K * (K+1) / 2; //1..K 개씩 담기
    if(sumK > N) {
        cout << -1;
        return 0;
    }
    int remain = N - sumK;
    if(remain % K == 0) cout << K-1;
    else cout << K; //위에서부터 remain개만큼 주면됨
    return 0;
}