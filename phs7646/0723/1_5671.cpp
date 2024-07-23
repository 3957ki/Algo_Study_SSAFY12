#include<iostream>
#include<vector>
using namespace std;

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int a,b;
    while(cin >> a) {
        cin >> b;
        int count = 0;
        for(int i = a;i <= b;i++) {
            //is i good?
            bool used[10] = {false};
            int val = i;
            bool flag = true;
            while(val > 0) {
                int digit = val%10;
                if(used[digit]) {
                    flag = false;
                    break;
                }
                used[digit] = true;
                val/=10;
            }
            if(flag) count++;
        }
        cout << count << "\n";
    }

    return 0;
}