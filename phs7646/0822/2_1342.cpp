#include<iostream>
#include<string>
using namespace std;

int l;
int num[26];
int answer = 0;
void dfs(int pos,int prev) {
    if(pos == l) answer++;
    for(int i = 0;i < 26;i++) {
        if(num[i] == 0) continue;
        if(i == prev) continue;
        num[i]--;
        dfs(pos+1,i);
        num[i]++;
    }
}

int main() {
    string  s; cin >> s;
    l = s.size();
    for(char c : s) num[c-'a']++;
    dfs(0,-1);
    cout << answer;
    return 0;
}