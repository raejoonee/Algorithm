#include <iostream>
 
using namespace std;
 
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int T;
    cin >> T;
    for (int tc = 1; tc <= T; tc++) {
        int answer = 0;
        string bit;
        cin >> bit;
        char curChar = '0';
        for (int i = 0; i < bit.length(); i++) {
            if (curChar != bit[i]) {
                answer++;
                curChar = curChar == '1' ? '0' : '1';
            }
        }
        cout << '#' << tc << ' ' << answer << '\n';
         
    }
}
