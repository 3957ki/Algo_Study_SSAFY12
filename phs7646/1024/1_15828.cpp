#include<iostream>
#include<queue>
using namespace std;

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int N; cin >> N;
    queue<int> q;
    int input;
    cin >> input;
    while(input != -1) {
        if(input == 0) {
            q.pop();
        } else {
            if(q.size() < N) q.emplace(input);
        }
        cin >> input;
    }
    if(q.empty()) cout << "empty";
    else while(!q.empty()) {
        cout << q.front() << " ";
        q.pop();
    }
    return 0;
}