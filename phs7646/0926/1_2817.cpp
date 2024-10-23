#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

typedef pair<double,int> pp;

bool isUsed[26];
int _count[26];
int main() {
    int X;cin >> X;
    int N; cin >> N;
    vector<pp> v;
    for(int i = 0;i < N;i++) {
        char c; cin >> c;
        int vote; cin >> vote;
        if(vote*20 < X) continue;
        int idx = c-'A';
        isUsed[idx] = true;
        for(int j = 1;j <=14;j++) v.emplace_back(vote/j,idx);
    }
    sort(v.begin(),v.end(),greater<pp>());
    for(int i = 0;i < 14;i++) {
        _count[v[i].second]++;
    }
    for(int i = 0;i < 26;i++) {
        if(!isUsed[i]) continue;
        cout << (char)('A'+i) << " " << _count[i] << "\n";
    }
    return 0;
}
