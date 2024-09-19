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
        if(N == 1) {
            cout << 0 << "\n";
            continue;
        }
        int cur = 1;
        int cnt = 0;
        for(int i = 1;i <= N;i++) {
            cur = arr[cur];
            cnt++;
            if(cur == N) {
                break;
            }
        }
        if(cur == N) cout << cnt << "\n";
        else cout << 0 << "\n";
    }
    return 0;
}