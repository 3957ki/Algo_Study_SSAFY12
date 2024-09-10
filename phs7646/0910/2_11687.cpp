#include<iostream>

using namespace std;
typedef long long ll;

ll _count(ll value) {
    ll ret = 0;
    ll div = value/5;
    while(div > 0) {
        ret += div;
        div /= 5;
    }
    return ret;
}

int main() {
    //5가 M개 있어야함
    //5의 갯수가 M개인 최소 N찾기
    //verify O(log N) : N/5 + N/5^2 + N/5^3 ....
    ll M; cin>> M;
    ll left = 1;
    ll right = M*5;
    ll answer = M*5+1;
    while(left <= right) {
        ll mid = (left+right)/2;
        ll c = _count(mid);
        if(c > M) {
            right = mid-1;//범위 줄이기
        } else if(c == M) {
            right = mid-1;//범위 줄이기
            answer = answer>mid?mid : answer;
        } else {
            left = mid+1;//범위늘리기
        }
    }
    if(answer == M*5+1) cout << -1;
    else cout << answer;
    return 0;
}