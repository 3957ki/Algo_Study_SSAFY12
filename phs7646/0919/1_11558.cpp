#include<iostream>
#include<vector>
using namespace std;

int arr[10001];
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int T; cin >> T;
    for(int t = 1;t <= T;t++) {
        int N; cin >> N;
        for(int i = 1;i <= N;i++) cin >> arr[i];
        vector<bool> visited(N+1);
        visited[1] = true;
        int cur = 1;
        int answer = 1;
        while(true) {
            int next = arr[cur];
            if(visited[next]) {
                answer = 0;
                break;
            } else if (next == N) break;
            visited[next] = true;
            cur = next;
            answer++;
        }
        cout << answer << "\n";
    }
    return 0;
}