#include<iostream>

using namespace std;
typedef long long ll;

int comb[2001][2001];
int MOD = 1000000007;

ll modpow(int K) {
    ll base = 1;
    ll mul = 2;
    while(K > 0) {
        if(K&1) {
            base = (base * mul)%MOD;
            K--;
        }
        else {
            mul = (mul * mul)%MOD;
            K >>= 1;
        }
    }
    return base;
}

int main() {
    int N,K;
    cin >> N >> K;
    comb[0][0] = 1;
    for(int i = 1;i <= N;i++) {
        comb[i][0] = 1;
        comb[i][i] = 1;
        for(int j = 1; j < i;j++) {
            comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % MOD;
        }
    }
    cout << (modpow(K-1) * comb[N][K]) % MOD;
    return 0;
}