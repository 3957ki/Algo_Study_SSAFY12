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
    int Nvalue;
    int K;
    cin >> Nvalue >> K;
    vector<int> v(K);
    for(int i = 0;i < K;i++) cin >> v[i];
    sort(v.begin(),v.end());
    int cur = 0;
    int len = 0;
    int _N = Nvalue;
    while(_N > 0) {
        _N /= 10;
        len++;
    }
    
    //cur을 N의 길이와 같이 v[0]로 꽉채운다
    for(int i = 0;i < len;i++) {
        cur = cur*10 + v[0];
    }

    //cur이 N보다 크다면 길이를 한칸 줄여야한다
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