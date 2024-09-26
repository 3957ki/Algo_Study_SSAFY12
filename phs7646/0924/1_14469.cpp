#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
typedef pair<int,int> pp;
int main() {
    int N; cin >> N;
    vector<pp> v;
    for(int i = 0;i < N;i++) {
        int a,b; cin >> a >> b;
        v.emplace_back(a,b);
    }
    sort(v.begin(),v.end());
    int time = 0;
    for(int i = 0;i < N;i++) {
        time = max(time,v[i].first) + v[i].second;
    }
    cout << time;
    return 0;
}