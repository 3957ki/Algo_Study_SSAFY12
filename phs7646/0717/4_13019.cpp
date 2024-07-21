#include<iostream>
#include<string>
#include<vector>

using namespace std;

int countA[26];
int countB[26];
int main() {
    string A,B;
    cin >> A >> B;
    int len = A.size();

    //구성하는 알파벳이 다르다면 만들 수 없다..
    for(int i = 0;i < len;i++) {
        countA[A[i]-'A']++;
        countB[B[i]-'A']++;
    }
    for(int i = 0;i < 26;i++) {
        if(countA[i] != countB[i]) {
            cout << -1;
            return 0;
        }
    }

    //maxl을 늘려가자
    //maxl이 1임은 보장된다
    int answer = 1;
    for(int maxl = 2;maxl <= len;maxl++) {
        //maxl만큼이 가능한가?
        bool flag = true;
        int pos = 0;
        for(int i = len-maxl;i < len;i++) {
            char target = B[i];
            bool found = false;
            while(pos < len) {
                if(A[pos++] == target) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                flag = false;
                break;
            }
        }
        if(!flag) break;
        else answer++;
    }
    cout << len-answer;
    return 0;
}