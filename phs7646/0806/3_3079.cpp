#include<iostream>
#include<vector>
#include<climits>

#define bignum 1000000007
using namespace std;

int main() {
    int N,M; cin >> N >> M;
    vector<long long> T(N);
    long long Tmin = bignum;
    long long Tmax = 0;
    for(int i = 0;i < N;i++) {
        cin >> T[i];
        Tmin = min(Tmin,T[i]);
        Tmax = max(Tmax,T[i]);
    }
    long long left = 0; //Tmin 이 N개 있을때
    long long right = LONG_MAX; //Tmax가 N개 있을때
    long long answer = 0;
    while(left <= right) {
        long long mid = (left+right)/2;
        //mid초 안에 가능한가??
        long long total = 0;
        for(int i = 0;i < N;i++) {
            total += mid/T[i]; //mid / T[i] 명 만큼 처리함
            if(total >= M) break;
        }
        if(total >= M) {
            //M명 이상 처리했다면
            answer = mid;
            right = mid-1;
        } else {
            left = mid+1;
        }
    }
    cout << answer;
    return 0;
}