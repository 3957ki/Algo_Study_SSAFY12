#include<iostream>
#include<climits>
#define MAXN 123456
using namespace std;
typedef long long ll;
ll N,Hatk;
ll t[MAXN];
ll a[MAXN];
ll h[MAXN];

bool enough(ll HP) {
    //HP로 시작하면 용을 잡을 수 있는가..??
    ll atk = Hatk;
    ll hp = HP;
    ll MAXHP = HP;
    for(ll i = 0;i < N;i++) {
        if(t[i] == 1) {
            //공격력 a[i], 체력 h[i]인 적과 전투
            ll num_atk = (h[i]+atk-1) / atk;
            ll num_hit = (hp+a[i]-1) / a[i];
            //num_atk와 num_hit이 같을 땐 이김
            if(num_atk > num_hit) return false;
            //num_atk-1 만큼 맞아야함
            hp -= (num_atk-1) * a[i];
        } else {
            //포션
            atk += a[i];
            hp = min(hp+h[i],MAXHP);
        }
    }
    return true;
}

int main() {
    N; cin >> N;
    Hatk; cin >> Hatk;
    for(ll i = 0;i < N;i++) cin >> t[i] >> a[i] >> h[i];
    ll left = 1;
    ll right = LLONG_MAX-1;
    ll answer = LLONG_MAX-1;
    while(left <= right) {
        ll mid = (left+right)/2;
        bool flag = enough(mid);
        if(flag) {
            answer = answer>mid? mid : answer;
            right = mid-1; //범위 줄이기
        } else {
            left = mid+1;
        }
    }
    cout << answer;
    return 0;
}