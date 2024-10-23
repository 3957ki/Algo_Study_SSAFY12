#include<iostream>
#include<set>
#include<string>
using namespace std;

int main() {
    int N; cin >> N;
    set<string> s;
    s.emplace("ChongChong");
    for(int i = 0;i < N;i++) {
        string a,b;
        cin >> a >> b;
        if(s.find(a) != s.end()) s.emplace(b);
        else if(s.find(b) != s.end()) s.emplace(a);
    }
    cout << s.size();
    return 0;
}