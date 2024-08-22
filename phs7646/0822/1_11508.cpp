#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
    int N; cin >> N;
    vector<int> v(N);
    for(int i = 0;i < N;i++) cin >> v[i];
    sort(v.begin(),v.end(),greater<int>());
    int sum = 0;
    for(int i = 0;i < N;i++) {
        if(i%3 == 2) continue;
        sum += v[i];
    }
    cout << sum;

    return 0;
}