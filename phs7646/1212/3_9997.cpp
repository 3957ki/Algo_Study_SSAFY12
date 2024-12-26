#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<string>

using namespace std;
int complete = (1<<26)-1;

int N;
vector<int> words;

int recur(int cur, int point) {
    if(point == N) return 0;
    int ret = 0;
    //현재 상태 포함하기
    int next = cur | words[point];
    if(next == complete) ret += (1<<(N-point-1));
    else ret += recur(next,point+1);
    //현재 상태 포함하지 않기
    ret += recur(cur,point+1);
    return ret;
}

int main() {
    cin >> N;
    words.resize(N);
    for(int i = 0;i < N;i++) {
        string s; cin >> s;
        for(char c : s) {
            words[i] |= (1<<(c-'a'));
        }
    }
    cout << recur(0,0);
    return 0;
}