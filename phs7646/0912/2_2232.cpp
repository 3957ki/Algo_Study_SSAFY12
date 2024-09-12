#include<iostream>
#include<vector>

using namespace std;

int arr[50000];
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    //local maximum의 갯수..!
    vector<int> ret;
    int N; cin >> N;
    if(N==1) {
        cout << 1;
        return 0;
    }
    for(int i = 0;i < N;i++) {
        cin >> arr[i];
        if(i >= 2 && arr[i-1] >= arr[i-2] && arr[i-1] >= arr[i]) {
            ret.emplace_back(i);
        }
    }
    if(arr[N-1] >= arr[N-2]) ret.push_back(N);
    if(arr[0] >= arr[1]) cout << 1 << '\n';
    for(int n : ret) cout << n << '\n';
    return 0;
}