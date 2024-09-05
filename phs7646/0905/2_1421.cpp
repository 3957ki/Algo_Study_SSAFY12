#include <iostream>
#include<vector>
using namespace std;
 
long long arr[50];
int main() {
    long long N,C,W;
    cin >> N >> C >> W;
    for(int i = 0;i < N;i++) cin >> arr[i];
    long long answer = 0;
    for(int L = 1;L <= 10000;L++) {
        long long cost = 0;
        for(int i = 0;i < N;i++) {
            if(arr[i] < L) continue;
            if(arr[i] == L) {
                cost += L*W;
            } else if(arr[i] == 2*L) {
                //이득일 때만 자른다
                long long newCost = 2*L*W - C;
                if(newCost > 0) cost += newCost;
            } else if(arr[i] % L == 0) {
                //이득일 때 만 자른다
                int dum = arr[i] / L;
                long long newCost = arr[i] * W - (dum-1) * C;
                if(newCost > 0) cost += newCost;
            } else {
                //이득일 때만 자른다
                int dum = arr[i] / L;
                long long newCost = dum*L*W - C*dum;
                if(newCost > 0) cost += newCost;
            }
        }
        //cout << L << " : "  << cost << endl;
        answer = max(answer,cost);
    }
    cout << answer;
    return 0;
}