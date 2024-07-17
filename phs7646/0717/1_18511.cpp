#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
using namespace std;

int tenpow(int n) {
    int ret = 1;
    for(int i = 0;i < n;i++) ret *= 10;
    return ret;
}

int main() {
    string N;
    int K;
    cin >> N >> K;
    vector<int> v(K);
    for(int i = 0;i < K;i++) cin >> v[i];
    sort(v.begin(),v.end());
    int Nvalue = 0;
    int cur = 0;
    int len = N.size();
    for(int i = 0;i < len;i++) {
        Nvalue = Nvalue*10 + (N[i]-'0');
        cur = cur*10 + v[0];
    }
    if(cur > Nvalue) {
        cur -= v[0] * tenpow(len-1);
        len--;
    }

    //그리디하게 앞에서부터 가장 큰수를 넣는다
    for(int i = 0;i < len;i++) {
        int ten = tenpow(len-i-1);
        for(int j = 1;j < K;j++) {
            //j-1에서 j로 교체
            int diff = (v[j]-v[j-1]) * ten;
            if(cur + diff <= Nvalue) {
                cur += diff;
            } else {
                break;
            }
        }
    }
    cout << cur;
    return 0;
}