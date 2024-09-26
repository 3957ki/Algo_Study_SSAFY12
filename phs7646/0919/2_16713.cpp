#include<iostream>
using namespace std;

int accum[1000001];
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    
    int N,Q; cin >> N >> Q;
    for(int i = 1;i <= N;i++) {
        int a; cin >> a;
        accum[i] = accum[i-1] ^ a;
    }
    int answer = 0;
    for(int q = 0;q < Q;q++) {
        int s,e; cin >> s >> e;
        answer ^= (accum[e] ^ accum[s-1]);
    }
    cout << answer;
    return 0;
}