#include<iostream>
#include<vector>
#include<string>
#include<unordered_map>
using namespace std;
unordered_map<string,string> map;
unordered_map<string,bool> visited;
void visit(string s) {
    string next = map[s];
    if(!visited[next]) {
        visited[next] = true;
        visit(next);
    }
}

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int tc = 1;
    int N;
    cin >> N;
    do {
        //initialize
        map.clear();
        visited.clear();
        //input
        for(int i = 0;i < N;i++) {
            string s1,s2;
            cin >> s1 >> s2;
            map[s1] = s2;
        }
        int count = 0;
        for(pair<string,string> p : map) {
            if(visited[p.first]) continue;
            visited[p.first] = true;
            visited[p.second] = true;
            visit(p.second);
            count++;
        }
        cout << tc++ << " " << count << "\n";
        cin >> N;
    } while(N != 0);
    return 0;
}