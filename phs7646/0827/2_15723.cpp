#include<iostream>
#include<string>
#include<memory.h>
using namespace std;

int is[26];

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    memset(is,-1,sizeof(is));
    int N;cin >> N;
    for(int i = 0;i < N;i++) {
        string s1,s2,s3; cin >> s1 >> s2 >> s3;
        is[s1[0]-'a'] = s3[0]-'a';
    }
    int M;cin >> M;
    for(int i = 0;i < M;i++) {
        string s1,s2,s3; cin >> s1 >> s2 >> s3;
        int start = s1[0]-'a';
        int end = s3[0]-'a';
        do {
            if(start == end) break;
            start = is[start]; 
        } while(start != -1);
        if(start == end) cout << "T\n";
        else cout << "F\n";
    }
    return 0;
}