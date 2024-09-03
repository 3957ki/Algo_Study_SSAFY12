#include<iostream>
#include<cmath>
using namespace std;

int nCk(int n,int k) {
    int ret = 1;
    for(int i = 0;i < k;i++) ret *= (n-i);
    for(int i = 2;i <= k;i++) ret /= i;
    return ret;
}

// 10^N
// - mC1 * 9^n
// + mC2 * 8^n
// - mC3 * 7^n
// ...

//전체 경우
//- (숫자 하나 없이 만들어진 경우)
//+ (숫자 두개 없이 만들어진 경우)
//- (숫자 세개 없이 만들어진 경우)
//....

int main() {
    int n,m; cin >> n >> m;
    //숫자 10-m 개로 n자릿수만들기?
    //숫자 m개가 전부 들어가야함
    int answer = pow(10,n);
    for(int k = 1;k <= m;k++) {
        if(k&1) answer -= nCk(m,k)*pow(10-k,n);
        else answer += nCk(m,k)*pow(10-k,n);
    }
    cout << answer;
    return 0;
}