#include<iostream>
#include<string>
#include<vector>
using namespace std;

bool isMoem(char c) {
    if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
    return false;
}

void Fail() {
    cout << "NO";
    exit(0);
}

int main() {
    int N,M; cin >> N >> M;
    string s; cin >> s;
    //뒤에서부터 가면서 자음 하나고르고, 그다음부터 A두개 고른다음,
    //나머지 가 M-3보다 많이 남았으면 가능!
    int ptr = N-1;
    char last;

    //자음 고르기
    while(ptr >= 0 && isMoem(s[ptr])) ptr--;
    if(ptr < 0) Fail();
    last = s[ptr];
    ptr--; //consume
    
    //A두개 고르기
    while(ptr >= 0 && s[ptr] != 'A') ptr--;
    if(ptr < 0) Fail();
    ptr--; //consume
    while(ptr >= 0 && s[ptr] != 'A') ptr--;
    if(ptr < 0) Fail();
    ptr--; //consume

    //ptr+1개가 남았음 0..ptr
    if(ptr+1 < M-3) Fail();

    cout << "YES\n";
    for(int i = 0;i < M-3;i++) cout << s[i];
    cout << "AA";
    cout << last;
    return 0;
}