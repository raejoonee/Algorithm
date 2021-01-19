#include <iostream>
#include <string>

using namespace std;

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        string s; cin >> s;
        string ans = "";
        for (int i = 0; i < s.size(); i++){
                switch(s[i]){
                        case '0':
                        ans+="000";
                        break;
                        case '1':
                        ans+="001";
                        break;
                        case '2':
                        ans+="010";
                        break;
                        case '3':
                        ans+="011";
                        break;
                        case '4':
                        ans+="100";
                        break;
                        case '5':
                        ans+="101";
                        break;
                        case '6':
                        ans+="110";
                        break;
                        case '7':
                        ans+="111";
                        break;
                }
        }
        string rans;
        for (int i = 0; i < ans.size(); i++){
                if (ans[i] == '1'){
                        rans = ans.substr(i);
                        break;
                }
        }
        if (rans == "") cout << '0';
        else cout << rans;
        return 0;
}