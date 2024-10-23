#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

typedef pair<int,int> pp;
bool isWin[100001];
bool isLoose[100001];


int solve(int K) {
    if(K==1) {
        cout << "Ringo";
        return 0;
    } else if(K==2) {
        cout << "Kali";
        return 0;
    }
    isWin[K] = true;
    priority_queue<int,vector<int>,greater<int>> q; q.emplace(K);
    while(!q.empty()) {
        int cur = q.top(); q.pop();
        if(isWin[cur]) {
            //cur이 이기는 수로 추가됨
            //cur의 분할 a+b중 b가 a의 약수인 a는 지는 수임
            for(int a = (cur+1)>>1; a <= cur-1;a++) {
                if(isWin[a] || isLoose[a]) continue;
                if(a % (cur-a) == 0) {
                    isLoose[a] = true;
                    if(a==2) {
                        if(isLoose[2]) return 0;
                        else return 1;
                    }
                    q.emplace(a);
                }
            }
        } else {
            //cur이 지는 수로 추가됨
            //cur의 분할 a+b 중 b가 a의 약수인 a는 이기는 수임
            for(int a = (cur+1)>>1; a <= cur-1;a++) {
                if(isWin[a] || isLoose[a]) continue;
                if(a % (cur-a) == 0) {
                    isWin[a] = true;
                    if(a==2) {
                        if(isLoose[2]) return 0;
                        else return 1;
                    }
                    q.emplace(a);
                }
            }
        }
    }
    return 0;
}

int main() {
    cout << "prog start..!!\n";
    for(int K = 3;K <= 100000;K++) {
        if(solve(K) == 1) cout << K << endl;
    }
    return 0;
}