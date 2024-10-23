#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

typedef long long ll;

vector<ll> v;
int N;
ll K;
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    cin >> N >> K;
    for(int i = 0;i < N;i++) {
        ll a; cin >> a; v.emplace_back(a);
    }
    sort(v.begin(),v.end());
    ll max_v = 0;
    for(int i = 0;i < N-1;i++) {
        //i번까지를 한 그룹으로, i+1번부터 한 그룹으로
        ll sum_v = v[0] * (i+1) + v[i+1] * (N-i-1);
        max_v = max(max_v,sum_v);
    }
    ll answer = K%max_v == 0 ? K/max_v : K/max_v+1;
    cout << answer;
    return 0;
}