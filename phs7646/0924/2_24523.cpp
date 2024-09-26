    #include<iostream>

    using namespace std;

    int main() {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
        int N; cin >> N;
        int idx = 0;
        int prev; cin >> prev;
        for(int i = 2;i <= N;i++) {
            int cur; cin >> cur;
            if(prev == cur) continue;
            else {
                while(idx < i-1) {
                    cout << i << " ";
                    idx++;
                }
                prev = cur;
            }
        }
        while(idx <= N-1) {
            cout << -1 << " ";
            idx++;
        }
        return 0;
    }