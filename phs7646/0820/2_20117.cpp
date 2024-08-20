#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
    int N; cin >> N;
    vector<int> v(N);
    for(int i = 0;i < N;i++) cin >> v[i];
    sort(v.begin(),v.end());
    if(N%2 == 0) {
        int sum = 0;
        for(int i = N/2; i < N;i++) sum += v[i];
        cout << sum * 2;
    } else {
        int sum = 0;
        for(int i = N/2+1; i < N;i++) sum += v[i];
        cout << sum * 2 + v[N/2];
    }
    return 0;
}