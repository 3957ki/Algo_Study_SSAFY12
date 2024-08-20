#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
    int N; cin >> N;
    vector<int> x(N);
    vector<int> y(N);
    for(int i = 0;i < N;i++) cin >> x[i] >> y[i];
    sort(x.begin(),x.end());
    sort(y.begin(),y.end());

    int mx = x[(N-1)/2];
    int my = y[(N-1)/2];
    long long answer = 0;
    for(int i = 0;i < N;i++) answer += abs(mx-x[i]) + abs(my-y[i]);
    cout << answer;

    return 0;
}