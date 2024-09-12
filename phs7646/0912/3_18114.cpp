#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N,C;
int main() {
    cin >> N >> C;
    
    vector<int> v(N);
    for(int i = 0;i < N;i++) {
        cin >> v[i];
        if(v[i] == C) { //한개 확인
            cout << 1;
            exit(0);
        }
    }

    sort(v.begin(),v.end());

    //두개를 고르고, 두개보다 큰 인덱스에 대해 이분탐색!
    for(int i = 0;i < N-1;i++) {
        for(int j = i+1; j < N;j++) {
            int rem = C-v[i]-v[j];
            if(rem == 0) { //두개 확인
                cout << 1;
                exit(0);
            } else if(rem < 0) continue;
            auto it = lower_bound(v.begin()+j+1,v.end(),rem);
            if(it != v.end() && *it == rem) { //이분 탐색
                cout << 1;
                exit(0);
            }
        }
    }
    cout << 0;
    return 0;
}