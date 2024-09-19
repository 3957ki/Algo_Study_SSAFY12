#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

typedef pair<int,int> pp;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N; cin >> N;
    vector<pp> events;
    for(int i = 1;i <= N;i++) {
        int a,b; cin >> a >> b;
        events.emplace_back(a,i);
        events.emplace_back(b+1,i);
    }
    sort(events.begin(),events.end());

    int cur = 0;
    int answer = 0;
    int cursor = 0;
    vector<bool> answer_elems(N+1);
    vector<bool> visited(N+1);
    
    while(cursor < events.size()) {
        int coord = events[cursor].first;
        
        while(cursor < events.size() && events[cursor].first == coord) {
            if(visited[events[cursor].second]) {
                cur--;
                visited[events[cursor].second] = false;
            } else {
                cur++;
                visited[events[cursor].second] = true;
            }
            cursor++;
        }

        if(answer < cur) {
            answer = cur;
            answer_elems = visited;
        }
    }

    cout << answer << "\n";
    for(int i = 1; i <= N; i++) 
        if(answer_elems[i]) cout << i << " ";
    return 0;
}
