#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;

    vector<vector<int>> v(N);
    for (int i = 0; i < N; i++) {
        int M;
        cin >> M;
        v[i].resize(M);
        for (int j = 0; j < M; j++) {
            cin >> v[i][j];
        }
    }

    vector<vector<int>> dp(N, vector<int>(10, -1));
    for (int dduck : v[0]) {
        dp[0][dduck] = 0;
    }

    for (int day = 1; day < N; day++) {
        for (int dduck : v[day]) {
            for (int prev = 1; prev <= 9; prev++) {
                if (dp[day-1][prev] != -1 && prev != dduck) {
                    dp[day][dduck] = prev;
                }
            }
        }
    }

    int last = -1;
    for (int i = 1; i <= 9; i++) {
        if (dp[N-1][i] != -1) {
            last = i;
            break;
        }
    }

    if (last == -1) {
        cout << -1 << endl;
    } else {
        vector<int> answer(N);
        for (int day = N-1; day >= 0; day--) {
            answer[day] = last;
            last = dp[day][last];
        }
        for (int d : answer) {
            cout << d << endl;
        }
    }

    return 0;
}
