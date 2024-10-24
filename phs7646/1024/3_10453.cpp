#include<iostream>
#include<string>
using namespace std;

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int T; cin >> T;
    for(int t = 1;t <= T;t++) {
        string s1,s2; cin >> s1 >> s2;
        if(s1.size() != s2.size()) {
            cout << -1 << '\n';
            continue;
        }
        int slen = s1.size();
        int cnt = 0;
        bool flag = true;
        for(int cursor = 0;cursor < slen;cursor++) {
            if(s1[cursor] == s2[cursor]) continue;

            //바꿔주기
            int next = cursor+1;
            while(next < slen && s1[next] != s2[cursor]) next++;
            //cursor와 next를 교환
            cnt += next-cursor;
            s1[next] = s1[cursor];
        }
        cout << cnt << '\n';
    }
    return 0;
}