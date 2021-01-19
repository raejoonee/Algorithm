#include <stack>
#include <string>
#include <iostream>
#include <cmath>

using namespace std;

int cnt = 0;
int jari = 0;

string conv(string s){
        int tmp = 0;
        string go = "";
        for (int i = s.size() - 1; i >= 0; i--){
                if (i == 0){
                        go = to_string(tmp) + go;
                        break;
                }
                if (cnt % 3 == 0 && cnt != 0){
                        go = to_string(tmp) + go;
                        cnt = 0;
                        jari = 0;
                } else {
                        if (s[i] == '1'){
                                tmp += pow(2, jari);
                        }
                }
                jari++;
                cnt++;
        }
        return go;
}

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        stack<int> numbers;
        string s;
        cin >> s;
        cout << conv(s);
        return 0;


}