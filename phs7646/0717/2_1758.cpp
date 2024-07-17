#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int N;
int main() {
    cin >> N;
    vector<int> v(N);
    for(int i = 0;i < N;i++) cin >> v [i];
    sort(v.begin(),v.end(),greater<int>());
    int pick = 1;
    long long answer = v[0];
    for(int i = 1;i < N;i++) {
        //줄의 맨앞에 추가할 떄, 추가하는게 이득인가 그렇지 않은가
        //선택하면 pick만큼의 페널티가 생김
        if(pick < v[i]) {
            //선택
            answer += v[i] - pick;
            pick++;
        } else break;   
    }
    cout << answer;
    return 0;
}