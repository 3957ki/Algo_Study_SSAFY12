#include<iostream>
#include<string>
#include<vector>

using namespace std;
typedef long long ll;
int _countW[52]; //대문자 - 소문자
int _countS[52];

int CharToInt(char c) {
    if(c >= 'a') return 26+(c-'a');
    else return c-'A';
}
bool isSame() {
    for(int i = 0;i < 52;i++) {
        if(_countW[i] != _countS[i]) return false;
    }
    return true;
}

int main() { 
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int g,s; cin >> g >> s;
    string W,S; cin >> W >> S;

    
    
    for(char c : W) {
        _countW[CharToInt(c)]++;
    }
    for(int i = 0;i < g;i++) {
        _countS[CharToInt(S[i])]++;
    }
    
    int answer = 0;
    if(isSame()) answer++;
    int ptr = g-1;
    while(ptr < s-1) {
        //move ptr
        ptr++;
        //remove ptr-g
        _countS[CharToInt(S[ptr-g])]--;
        //add ptr
        _countS[CharToInt(S[ptr])]++;
        //count
        if(isSame()) answer++;
    }

    cout << answer;

    return 0;
}