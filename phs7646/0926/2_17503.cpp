#include<iostream>
#include<vector>
#include<algorithm>
#include<climits>
using namespace std;
typedef long long ll;
typedef pair<ll,ll> pp;

ll INF = 1e10;

int main() {
    ll N,M,K;
    cin >> N >> M >> K;
    vector<pp> v;
    for(int i = 0;i < K;i++) {
        ll a,b; cin >> a >> b;
        v.emplace_back(b,a); //도수,선호도
    }
    sort(v.begin(),v.end());

    ll left = 0;
    ll right = INF;
    ll answer = -1;
    while(left <= right) {
        ll mid = (left+right)/2;
        //mid의 간레벨.. mid이하의 맥주 마실 수 있다.
        pp query = {mid,INF};
        auto it = upper_bound(v.begin(),v.end(),query);
        ll idx = it-v.begin()-1; // idx까지 마실 수 있다!
        
        bool flag = true;
        if(idx+1 < N) flag = false;
        ll sum_v = 0;
        vector<ll> eatable;
        for(int i = 0;i <= idx;i++) eatable.emplace_back(v[i].second);
        sort(eatable.begin(),eatable.end(),greater<ll>());
        for(int i = 0;i < N;i++) {
            if(i >= eatable.size()) break;
            sum_v += eatable[i];
        }
        if(sum_v < M) flag = false;

        if(flag) {
            if(answer == -1) answer = mid;
            else answer = min(answer,mid);
            right = mid-1;
        } else left = mid+1;
    }
    cout << answer;


    return 0;
}