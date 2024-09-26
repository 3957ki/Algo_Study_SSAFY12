#include<iostream>
#include<vector>
#include<algorithm>
#include<climits>
#include<queue>
using namespace std;
typedef long long ll;
typedef pair<ll,ll> pp;

int main() {
    ll N,M,K;
    cin >> N >> M >> K;
    vector<pp> v;
    for(int i = 0;i < K;i++) {
        ll a,b; cin >> a >> b;
        v.emplace_back(b,a); //도수,선호도
    }
    sort(v.begin(),v.end());

    priority_queue<ll,vector<ll>,greater<ll>> pq; //minheap
    ll _sum = 0;
    ll answer = 0;
    int consume = 0;
    //일단 N개 먹기
    while(pq.size() < N) {
        if(consume >= K) break;
        answer = v[consume].first; //consume만큼의 도수 먹기
        while(consume < K && v[consume].first <= answer) {
            //consume 먹기
            pq.emplace(v[consume].second);
            _sum += v[consume].second;
            consume++;
        }
    }

    while(true) {
        //최대 N개만 먹을 수 있으니까 뱉어내기
        while(pq.size() > N) {
            _sum -= pq.top();
            pq.pop();
        }
        //만족하는가..??
        if(_sum >= M) {
            cout << answer;
            return 0;
        }
        
        //다음 맥주 먹기
        if(consume >= K) break; //맥주가 부족하다..!

        answer = v[consume].first; //consume만큼의 도수 먹기
        while(consume < K && v[consume].first <= answer) {
            //consume 먹기
            pq.emplace(v[consume].second);
            _sum += v[consume].second;
            consume++;
        }
    }
    cout << -1;
    return 0;
}