#include<iostream>
#include<algorithm>
using namespace std;
bool isBad[100001];
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    //input
    int N,K,B; cin >> N >> K >> B;
    for(int i = 0;i < B;i++) {
        int b; cin >> b;
        isBad[b] = true; 
    }
    int answer = K;
    int cnt = 0;
    //build initial cnt
    for(int i = 1;i <= K;i++) if(isBad[i]) cnt++;
    answer = min(answer,cnt);
    //slide window
    for(int i = K+1;i <= N;i++) {
        //add i, remove i-K
        if(isBad[i]) cnt++;
        if(isBad[i-K]) cnt--;
        answer = min(answer,cnt);
    }
    
    cout << answer;
    return 0;
}