#include <string>
#include <vector>
#include <iostream>

using namespace std;

int cal(int a){
        int ans = 0;
        string s = to_string(a);
        for (int i = 0; i < s.size(); i++){
                ans+=s[i] -'0';
        }
        if (ans >= 10){
                return cal(ans);
        } else {
                return ans;
        }
}

int main(){
        ios_base::sync_with_stdio(false);
        vector<int> qs;
        int input;
        cin >> input;
        qs.push_back(input);
        while(input){
                cin >> input;
                if (input == 0) break;
                qs.push_back(input);
        }
        for (int i = 0; i < qs.size(); i++){
                cout << cal(qs[i]) << '\n';
        }
        return 0;
}

// int main(){
//         ios_base::sync_with_stdio(false);
//         vector<int> problem;
//         vector<int> answer;
//         int a;
//         do {
//                 cin >> a;
//                 if (a == 0) break;
//                 problem.push_back(a);
//         } while (a != 0);
//         for (int i = 0; i < problem.size(); i++){
//                 int ans;
//                 while (problem[i]){
//                         ans += (problem[i] % 10);
//                         problem[i] /= 10;
//                         cout << "i: " << i << " problem[i]: " << problem[i] << " ans: " << ans << endl;
//                 }
//                 answer.push_back(ans);
//         }
//         for (int i = 0; i < answer.size(); i++){
//                 cout << answer[i] << '\n';
//         }
//         return 0;
// }