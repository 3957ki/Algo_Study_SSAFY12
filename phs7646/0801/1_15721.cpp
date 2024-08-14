#include<iostream>

using namespace std;

int main() {
    int A,T,option;
    cin >> A >> T >> option;
    int index = 0;
    int cur = 8; //현재 회차의 길이
    int accum = 0;
    while(true) {
        if(accum + cur/2 >= T) break;
        index += cur;
        accum += cur/2; //절반 만큼이 쌓인다
        cur += 2;
    }
    if(T-accum <= 2) {
        int p = T-accum;
        //뻔 데기 뻔 데기 에서 끝남
        if(p == 1) {
            index += 1+option;
        } else {
            index += 1+2 + option;
        }
    } else {
        //뻔 n 데기 n 에서 끝남
        index += 4;
        accum += 2;
        if(option == 0) {
            index += T-accum;
        } else {
            index += (cur-4)/2 + T-accum;
        }
    }
    cout << (index+A-1) % A;
    return 0;
}